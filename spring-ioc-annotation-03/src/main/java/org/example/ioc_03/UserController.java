package org.example.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @since: 2025/4/28 14:28
 * @author: qm
 * @description:
 */
@Controller
public class UserController {
    @Autowired  // 自动注入，相当于xml配置中的<property name="userService" ref="userService"/>
    @Qualifier(value = "userServiceImpl2") // 指定注入的Bean的名称（当有多个实现类时使用）【不能单独使用，需要和@Autowired一起使用】
    private UserService userService;

    // 自动注入，相当于xml配置中的<property name="userService" ref="userService"/>)
    // 等价于：@Autowired(required = true) + @Qualifier(value = "userServiceImpl")
    @Resource(name = "userServiceImpl")
    private UserService userService1;

    /**
     * 业务层
     */
    public void show() {
        String show = userService.show();
        System.out.println("UserController.show() = " + show);
        String show1 = userService1.show();
        System.out.println("UserController.show1() = " + show1);
    }

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
