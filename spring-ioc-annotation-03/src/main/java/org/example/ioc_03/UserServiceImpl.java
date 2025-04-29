package org.example.ioc_03;

import org.springframework.stereotype.Service;

/**
 * @since: 2025/4/28 14:30
 * @author: qm
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String show() {
        return "UserServiceImpl.show()";
    }
}
