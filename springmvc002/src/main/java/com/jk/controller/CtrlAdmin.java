package com.jk.controller;

import com.jk.model.User;
import com.jk.model.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class CtrlAdmin {

    /**
     * 返回:ModelAndView
     * 需要在springmvc配置文件spring-servlet.xml中加入配置:
     * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" p:prefix="/jsp/" p:suffix=".jsp"/>
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "resp1", method = RequestMethod.GET)
    public ModelAndView resp1(String id, String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resp1");

        User user = new User();
        user.setId("123");
        user.setName("杰克");
        mv.addObject(user);

        System.out.println(user);
        return mv;
    }


    /**
     * 直接将对象转为json返回
     * 加上@ResponseBody注解
     * 需在pom.xml添加jackson依赖
     *
     * @param id
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resp2")
    public Map<String, Object> resp2(String id, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "2000");
        map.put("desc", "ok");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/resp3")
    public Object resp3(String id, String name) {
        User user = new User();
        user.setName("rose");
        user.setId("1231");

        return user;
    }


}
