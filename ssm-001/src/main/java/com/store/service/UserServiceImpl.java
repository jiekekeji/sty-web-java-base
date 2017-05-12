package com.store.service;

import com.store.dao.UserDao;
import com.store.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jack on 16/5/27.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl {
    @Resource
    private UserDao userDao;

    public User getUserById(Long userId) {

        return userDao.findUserById(1l);
    }
}
