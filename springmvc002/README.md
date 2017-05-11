Springmvc参数获取和响应
----------


一、挂参数方式
-------------------

    1、Controller的方法参数名称和input表单的name值一致：
   
   ```
       @RequestMapping(value = "register4")
       @ResponseBody
       public String addUser4(String id, String name) {
           System.out.println("addUser4");
           return "addUser4=" + "id=" + id + "&name=" + name;
       }
   ```