package com.store.dao;

import com.store.mapper.*;
import com.store.model.User;
import com.store.model.UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by jack on 16/5/27.
 */
@Repository
public class UserDao extends AbstractDao {

    public User findUserById(long id) {
        System.out.println("findUserById");
        SqlSession session = this.getSqlSession();

        User user = new User();
        user.setUsername("rose");
        user.setPassword("123456789");
        System.out.println(session.insert("mapping.UserMapper.insertSelective", user));

        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(1l);
        System.out.println(session.selectOne("mapping.UserMapper.selectByExample", example));

        return user;
    }

    public int addUser(User user) {

        return 0;
    }

    public List<User> getAllUsers() {
        return null;
    }


}
