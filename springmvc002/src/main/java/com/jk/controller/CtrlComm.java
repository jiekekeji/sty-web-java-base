package com.jk.controller;

import com.jk.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Handsome on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/user")
public class CtrlComm {

    @RequestMapping(value = "comm1", method = RequestMethod.GET)
    @ResponseBody
    public Object comm1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());

        ServletContext context = session.getServletContext();
        System.out.println(context);

        return "comm1";
    }

}
