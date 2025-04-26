package org.example.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @since: 2025/4/26 16:35
 * @author: qm
 * @description:
 */
public class JdbcTemplateTest {
    /**
     * 不使用 IoC 容器配置的 JdbcTemplate 完成查询
     */
    @Test
    public void testJdbcTemplate0() {
        /*
         * JdbcTemplate 是 Spring提供的一个用于简化 JDBC 操作的类，它封装了 JDBC 的底层细节，简化了数据库的CRUD操作。
         * DruidDataSource 负责数据库连接池的管理，提供了高效的数据库连接。
         */
        // step 0. 创建一个 DruidDataSource 对象配置数据库连接信息
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:postgresql://localhost:15432/postgres");
        druidDataSource.setUsername("postgres");
        druidDataSource.setPassword("postgres");
        druidDataSource.setDriverClassName("org.postgresql.Driver");
        // step 1. 实例化 JdbcTemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // step 2. 设置数据源
        jdbcTemplate.setDataSource(druidDataSource);
        // step 3. 执行查询操作
        String sql = "SELECT * FROM students";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        // step 4. 遍历结果集
        for (Map<String, Object> row : result) {
            // step 5. 获取每一行的值
            int id = (int) row.get("id");
            String name = (String) row.get("name");
            int age = (int) row.get("age");
            // step 6. 打印结果
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        // 或者，将查询结果映射到 Student 对象
        sql = "SELECT id, name, gender, age, class FROM students";
        List<Student> students = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setAge(rs.getInt("age"));
            student.setClasses(rs.getString("class"));
            return student;
        });
        for (Student student : students) {
            System.out.println(student);
        }

        // step 7. 关闭数据源
        druidDataSource.close();
    }

    /**
     * 通个 IoC 容器配置的 JdbcTemplate 完成查询
     */
    @Test
    public void testJdbcTemplate1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // DML: insert
        // 插入一条记录
        String sql = "insert into students(id,name,gender,age,class) values (?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql, 100, "测试", "男", 20, "测试班");
        System.out.println("rows = " + rows);

        // DQL: select
        // 根据 id 查询一条记录
        sql = "SELECT * FROM students where id = ?";
//        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student student = new Student();
//                student.setId(rs.getInt("id"));
//                student.setName(rs.getString("name"));
//                student.setGender(rs.getString("gender"));
//                student.setAge(rs.getInt("age"));
//                student.setClasses(rs.getString("class"));
//                return student;
//            }
//        }, 1);
        // 使用 Lambda 表达式简化代码
        Student student = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Student student1 = new Student();
            student1.setId(rs.getInt("id"));
            student1.setName(rs.getString("name"));
            student1.setGender(rs.getString("gender"));
            student1.setAge(rs.getInt("age"));
            student1.setClasses(rs.getString("class"));
            return student1;
        }, 1);
        System.out.println(student);

        // 查询所有记录
        sql = "SELECT * FROM students";
        // 使用 BeanPropertyRowMapper 将结果集映射到 Student 对象。自动映射属性值要求列名和属性名一致（不一致则起别名）。
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList = " + studentList);
    }

    /**
     * 测试三层架构
     * 从IoC容器获取Controller并调用业务，内部都是IoC容器进行注入
     */
    @Test
    public void testJdbcTemplate2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");
        // 获取 StudentController 对象
        org.example.controller.StudentController studentController = context.getBean("studentController", org.example.controller.StudentController.class);
        // 调用 findAll 方法
        studentController.findAll();
        // 关闭 IoC 容器
        context.close();
    }
}
