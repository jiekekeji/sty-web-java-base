package com.store.service;

import com.github.pagehelper.PageHelper;
import com.store.dao.UserMapper;
import com.store.model.User;
import com.store.model.UserExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 16/5/27.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl {
    @Resource
    private UserMapper dao;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public Map<String, Object> addUser(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        int code = dao.insert(user);

        if (code == 1) {
            map.put("code", 2000);
            map.put("desc", "ok");
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }

    /**
     * 删除用户-根据用户id
     *
     * @param id
     * @return
     */
    public Map<String, Object> deleteUserByID(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        int code = dao.deleteByPrimaryKey(id);

        if (code == 1) {
            map.put("code", 2000);
            map.put("desc", "ok");
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }

    /**
     * 查找用户-根据用户id
     *
     * @param id
     * @return
     */
    public Map<String, Object> findUserByID(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = dao.selectByPrimaryKey(id);

        if (null != user) {
            map.put("code", 2000);
            map.put("desc", "ok");
            map.put("user", user);
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }

    /**
     * 查找多个用户
     *
     * @return
     */
    public Map<String, Object> findUserList() {
        Map<String, Object> map = new HashMap<String, Object>();

        UserExample example = new UserExample();
        List<User> users = dao.selectByExample(example);
        if (null != users) {
            map.put("code", 2000);
            map.put("desc", "ok");
            map.put("users", users);
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }

    /**
     * 修改用户-根据用户id
     *
     * @param user
     * @return
     */
    public Map<String, Object> updateUser(User user) {
        Map<String, Object> map = new HashMap<String, Object>();

        UserExample example = new UserExample();
        int code = dao.updateByPrimaryKey(user);
        if (code == 1) {
            map.put("code", 2000);
            map.put("desc", "ok");
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }


    /**
     * 分页查询-依赖mybatis的分页插件pagehelper
     *
     * @param page
     * @param limit
     * @return
     */
    public Map<String, Object> findUsersByPaging(int page, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();

        //设置页码和数量
        PageHelper.startPage(page, limit);

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        List<User> users = dao.selectByExample(example);
        if (null != users) {
            map.put("code", 2000);
            map.put("desc", "ok");
            map.put("users", users);
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }

    /*****有条件的删除，修改，查询,查询为例:**********/


    /**
     * 查询用户-多个and条件
     *
     * @param user
     * @return
     */
    public Map<String, Object> findUser1(User user) {
        Map<String, Object> map = new HashMap<String, Object>();

        UserExample example = new UserExample();
        //where username=? and age=18
        example.or().andUsernameEqualTo(user.getUsername()).andAgeEqualTo(user.getAge());

        List<User> users = dao.selectByExample(example);
        if (users != null) {
            map.put("code", 2000);
            map.put("desc", "ok");
            map.put("users", users);
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }

    /**
     * 修改用户-多个条件and的查询
     *
     * @param user
     * @return
     */
    public Map<String, Object> updateUser2(User user) {
        Map<String, Object> map = new HashMap<String, Object>();

        UserExample example = new UserExample();
        example.or().andUsernameEqualTo(user.getUsername()).andAgeEqualTo(user.getAge())
                .andGenderEqualTo(user.getGender());

        int code = dao.updateByExample(user, example);
        if (code == 1) {
            map.put("code", 2000);
            map.put("desc", "ok");
        } else {
            map.put("code", 4000);
            map.put("desc", "eroor");
        }
        return map;
    }


}
