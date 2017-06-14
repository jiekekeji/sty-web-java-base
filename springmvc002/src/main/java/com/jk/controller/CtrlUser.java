package com.jk.controller;

import com.jk.model.User;
import com.jk.model.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    public String addUser1(@PathVariable String id, @PathVariable String name) {
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
    public String addUser2(@ModelAttribute("pojo") User user) {
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
    public String addUser3(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println(id);
        return "addUser3=" + "id=" + id + "&name=" + name;
    }


    /**
     * 表单中input的name值和Controller的参数变量名保持一致，就能完成数据绑定
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "register4")
    @ResponseBody
    public String addUser4(String id, String name) {
        System.out.println("addUser4");
        return "addUser4=" + "id=" + id + "&name=" + name;
    }

    /**
     * 接收数组形式的参数：
     * 传参方式:?id=123&name=杰克&name=螺丝
     * 和controler的变量名一致
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "register5")
    @ResponseBody
    public String addUser5(String id, String[] name) {
        System.out.println("addUser5");
        System.out.println(name.length);
        return "addUser5=" + "id=" + id + "&name=" + name;
    }

    /**
     * @param user
     * @return
     * @RequestBody 接收json字符串，将json转为bean
     * 注解:@RequestBody User user
     * 需要jackson包,
     * 客户端请求时需在header加：Content-Type=application/json
     * 参数方式:
     * {"id":"123","name":"rose"}
     */
    @RequestMapping(value = "register6", method = RequestMethod.POST)
    @ResponseBody
    public String addUser6(@RequestBody User user) {
        System.out.println(user);
        return "addUser6=" + "id=" + user.getId() + "&name=" + user.getName();
    }

    /**
     * 获取json数组
     * 参数形式:[{"id":"123","name":"rose"},{"id":"456","name":"杰克"}]
     *
     * @param users
     * @return
     */
    @RequestMapping(value = "register7", method = RequestMethod.POST)
    @ResponseBody
    public String addUser7(@RequestBody List<User> users) {
        System.out.println(users.size());
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            System.out.println(u.getId());
            System.out.println(u.getName());
        }
        return "addUser7=" + users.size();
    }

    /**
     * 获取json混合类型,json的key值和bean的属性名要一致
     * {"type":"123","users":[{"id":"123","name":"rose"},{"id":"456","name":"杰克"}]}
     *
     * @param users
     * @return
     */
    @RequestMapping(value = "register8", method = RequestMethod.POST)
    @ResponseBody
    public String addUser8(@RequestBody UserList users) {
        System.out.println(users);
        return "addUser8=" + users;
    }

    /***********************
     * 上传文件
     ***************************/


    /**
     * 单文件上传 不带参数
     * pom.xml文件添加文件上传需要的jar
     * springmvc配置文件spring-servlet.xml添加:multipartResolver配置
     * 表单添加:enctype="multipart/form-data"
     * // <form method="post" enctype="multipart/form-data" action="/springmvc002/user/uploadfile1">
     * // <input type="file" name="file"/>
     * // <input type="submit" value="Submit"/>
     * //</form>
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadfile1", method = RequestMethod.POST)
    @ResponseBody
    public String loadFile1(@RequestParam("file") MultipartFile file) {
        // 文件存放服务端的位置
        String rootPath = "H:/TestDir";
        if (!file.isEmpty()) {
            if (saveFile(file)) {
                return "上传成功";
            }
        }
        return "上传失败";
    }


    /**
     * 多文件上传
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "uploadfile2", method = RequestMethod.POST)
    @ResponseBody
    public String loadFile2(@RequestParam("files") MultipartFile[] files) {
        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                if (saveFile(file)) {
                    list.add("ok");
                } else {
                    list.add("fail");
                }
            }
        }
        System.out.println(list);
        return list.toString();
    }


    /**
     * 带额外参数的文件上传
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "uploadfile3", method = RequestMethod.POST)
    @ResponseBody
    public String loadFile3(String userid, @RequestParam("files") MultipartFile[] files) {
        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                if (saveFile(file)) {
                    list.add("ok");
                } else {
                    list.add("fail");
                }
            }
        }
        System.out.println("userid=" + userid);
        System.out.println(list);
        return "userid=" + userid + "&&" + list.toString();
    }

    /**
     * 带额外参数的不同类型文件上传
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "uploadfile4", method = RequestMethod.POST)
    @ResponseBody
    public String loadFile4(String userid, @RequestParam("avatar") MultipartFile avatarFile, @RequestParam("documents") MultipartFile[] files) {
        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                if (saveFile(file)) {
                    list.add("ok");
                } else {
                    list.add("fail");
                }
            }
        }
        //保存avatar
        saveFile(avatarFile);
        System.out.println("userid=" + userid);
        System.out.println(list);
        return "userid=" + userid + "&&" + list.toString();
    }

    /**
     * 保存上传的文件
     *
     * @param MultipartFile file
     * @return
     */
    private Boolean saveFile(MultipartFile file) {
        // 文件存放服务端的位置
        String rootPath = "H:/TestDir";
        try {
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            file.transferTo(serverFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
