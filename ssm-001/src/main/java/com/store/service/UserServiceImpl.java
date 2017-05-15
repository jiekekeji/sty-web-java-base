package com.store.service;

import com.store.dao.UserMapper;
import com.store.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by jack on 16/5/27.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl {
    @Resource
    private UserMapper userDao;

    public User getUserById(Long userId) {
        User user = null;
        System.out.println("----------");
        System.out.println(userDao);
        System.out.println("----------");
        user = userDao.selectByPrimaryKey(1l);
        System.out.println("用户名="+user.getUsername());

        return user;
    }
}
