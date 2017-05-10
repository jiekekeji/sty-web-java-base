package com.store.webfont;

import com.store.dao.UserDao;
import com.store.model.User;
import com.store.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class WebUser {
    private static Logger logger = Logger.getLogger(WebUser.class);
    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public Object findUserById() {
        User user = userService.getUserById(1l);
        logger.info(user);
        return null;
    }
}
