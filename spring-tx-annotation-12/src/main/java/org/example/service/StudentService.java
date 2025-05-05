package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @since: 2025/5/5 19:28
 * @author: qingmu
 * @description:
 */
@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 添加事务：@Transactional
     * 位置：方法或者类上
     * - 方法：当前方法有事务
     * - 类：当前类所有方法都有事务
     */
    public void changeInfo() {
        studentDao.updateAgeById(88, 1);
        int i = 1 / 0; // 模拟异常
        System.out.println("-".repeat(30));
        studentDao.updateNameById("test1", 1);
    }

    // 只读事务
    // 一般情况下都在类上添加事务，然后在方法上添加只读事务
    @Transactional(readOnly = true)
    public void getInfo() {
        System.out.println(studentDao.getNameById(1));
    }

    @Transactional(readOnly = false, timeout = 3)
    public void getInfoTimeout() {
        System.out.println(studentDao.getNameById(2));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
        }
        studentDao.updateNameById("test3", 2);
    }

    /**
     * Spring事务的回滚机制
     * - 默认情况下，Spring事务只会回滚RuntimeException和Error
     * - 如果需要回滚其他异常，需要在@Transactional注解中添加rollbackFor属性
     * - rollbackFor属性可以指定需要回滚的异常类型
     * - noRollbackFor属性可以指定不需要回滚的异常类型（在回滚的情况下使用）
     */
    @Transactional(
            readOnly = false,
            timeout = 3,
            rollbackFor = Exception.class,
            noRollbackFor = FileNotFoundException.class,
            isolation = Isolation.REPEATABLE_READ  // 默认
    )
    public void tryException() throws FileNotFoundException {
        studentDao.updateNameById("test333", 3);
        new FileInputStream("xxx");
        studentDao.updateNameById("test44", 4);
    }

    /**
     * 两个独立的事务
     * *  propagation = Propagation.REQUIRED 默认值【推荐】
     * *    当父方法有事务，则加入父事务，最终是同一个事务
     * *  propagation = Propagation.REQUIRES_NEW
     * *    不管父方法，都是独立事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge() {
        studentDao.updateAgeById(77, 1);
        System.out.println("changeAge");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName() {
        studentDao.updateNameById("test22222", 1);
        System.out.println("changeName");
        int i = 1 / 0; // 模拟异常
    }
}
