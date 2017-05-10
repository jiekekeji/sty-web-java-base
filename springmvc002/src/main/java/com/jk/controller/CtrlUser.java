package com.jk.controller;

import com.jk.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class CtrlUser {

    /**
     * 通过@PathVariabl获取路径中的参数
     *
     * @return
     */
    @RequestMapping(value = "register1/{id}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Object addUser1(@PathVariable String id, @PathVariable String name) {
        System.out.println("id=" + id);
        System.out.println("name=" + name);
        return "addUser=" + "id=" + id + "&name=" + name;
    }

    /**
     * @param user
     * @return
     * @ModelAttribute获取POST请求的FORM表单数据
     */
    @RequestMapping(value = "register2", method = RequestMethod.POST)
    @ResponseBody
    public Object addUser2(@ModelAttribute("pojo") User user) {
        System.out.println("user=" + user.toString());
        return "addUser2=" + "id=" + user.getId() + "&name=" + user.getName();
    }


    /**
     * 直接用HttpServletRequest获取
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "register3", method = RequestMethod.GET)
    @ResponseBody
    public Object addUser3(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println(id);
        return "addUser3=" + "id=" + id + "&name=" + name;
    }
}
