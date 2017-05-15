package com.store.controller;

import com.store.model.User;
import com.store.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class UserCtrl {
    private static Logger logger = Logger.getLogger(UserCtrl.class);
    @Resource
    private UserServiceImpl service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object registerUser(@ModelAttribute("pojo") User user) {
        logger.info(user);
        if (null != user && null != user.getUsername() && null != user.getPassword()) {
            return service.addUser(user);
        }
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteUserByID(Long id) {
        logger.info(id);
        if (null != id) {
            return service.deleteUserByID(id);
        }
        return null;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Object findUserByID(Long id) {
        logger.info(id);
        if (null != id) {
            return service.findUserByID(id);
        }
        return null;
    }

    @RequestMapping(value = "/find/list", method = RequestMethod.POST)
    @ResponseBody
    public Object findUserList() {
        return service.findUserList();
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateUser(@ModelAttribute("pojo") User user) {
        return service.updateUser(user);
    }

    @RequestMapping(value = "/find/list/page", method = RequestMethod.POST)
    @ResponseBody
    public Object findUsersByPaging(int page, int limit) {
        return service.findUsersByPaging(page, limit);
    }


}
