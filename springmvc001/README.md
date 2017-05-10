Springmvc入门架子搭建
----------


一、pom.xml文件参考
-------------------
    ```
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>com.jk</groupId>
        <artifactId>springmvc001</artifactId>
        <packaging>war</packaging>
        <version>1.0-SNAPSHOT</version>
        <name>springmvc001 Maven Webapp</name>
        <url>http://maven.apache.org</url>
        <dependencies>
            <!--start 单元测试需要的包、-->
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>3.8.1</version>
                <scope>test</scope>
            </dependency>
            <!--end 单元测试需要的包、-->
            <!--start spring需要的jar包 -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>3.2.4.RELEASE</version>
                <type>jar</type>
            </dependency>

            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-core</artifactId>
                <version>3.2.4.RELEASE</version>
                <type>jar</type>
            </dependency>

            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-beans</artifactId>
                <version>3.2.4.RELEASE</version>
                <type>jar</type>
            </dependency>

            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-webmvc</artifactId>
                <version>3.2.4.RELEASE</version>
                <type>jar</type>
            </dependency>

            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-orm</artifactId>
                <version>3.2.4.RELEASE</version>
                <type>jar</type>
            </dependency>
            <!--end spring需要的jar包 -->

            <!--start 文件上传需要的jar包 -->
            <dependency>
                <groupId>commons-fileupload</groupId>
                <artifactId>commons-fileupload</artifactId>
                <version>1.2.1</version>
            </dependency>

            <dependency>
                <groupId>commons-io</groupId>
                <artifactId>commons-io</artifactId>
                <version>1.4</version>
            </dependency>
            <!--end 文件上传需要的jar包 -->
        </dependencies>
        <build>
            <finalName>springmvc001</finalName>
        </build>
    </project>
    ```
二、Springmvc配置文件spring-servlet.xml参考
-------------------
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context-4.0.xsd
                           http://www.springframework.org/schema/mvc
                           http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">

       <!-- 自动扫描  @Controller-->
       <context:component-scan base-package="com.jk.controller"/>

       <!-- springMVC开启注解 -->
       <mvc:annotation-driven/>

       <!-- 文件上传配置 -->
       <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
           <!-- 默认编码 -->
           <property name="defaultEncoding" value="UTF-8"/>
           <!-- 上传文件大小限制为31M，31*1024*1024 -->
           <property name="maxUploadSize" value="32505856"/>
           <!-- 内存中的最大值 -->
           <property name="maxInMemorySize" value="4096"/>
       </bean>

   </beans>
   ```

三、web.xml文件参考
-------------------
   ```
       <!DOCTYPE web-app PUBLIC
               "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
               "http://java.sun.com/dtd/web-app_2_3.dtd" >

       <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee"
                xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
                version="3.0">
           <display-name>Archetype Created Web Application</display-name>

           <!-- start 配置过滤器，同时把所有的请求都转为utf-8编码 -->
           <filter>
               <filter-name>EncodingFilter</filter-name>
               <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
               <init-param>
                   <param-name>encoding</param-name>
                   <param-value>UTF-8</param-value>
               </init-param>
               <init-param>
                   <param-name>forceEncoding</param-name>
                   <param-value>true</param-value>
               </init-param>
           </filter>

           <filter-mapping>
               <filter-name>EncodingFilter</filter-name>
               <url-pattern>/*</url-pattern>
           </filter-mapping>
           <!--end 配置过滤器，同时把所有的请求都转为utf-8编码 -->

           <!--start 加载spring配置文件  -->
           <context-param>
               <param-name>contextConfigLocation</param-name>
               <!--resources目录下的spring-servlet.xml文件-->
               <param-value>classpath:spring-servlet.xml</param-value>
           </context-param>
           <listener>
               <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
           </listener>
           <!-- end 加载spring配置文件 -->

           <!--start springMVC配置 -->
           <servlet>
               <servlet-name>Dispatcher</servlet-name>
               <servlet-class>
                   org.springframework.web.servlet.DispatcherServlet
               </servlet-class>
               <init-param>
                   <param-name>contextConfigLocation</param-name>
                   <param-value>classpath:spring-servlet.xml</param-value>
               </init-param>
               <load-on-startup>1</load-on-startup>
           </servlet>
           <servlet-mapping>
               <servlet-name>Dispatcher</servlet-name>
               <url-pattern>/</url-pattern>
           </servlet-mapping>
           <!--end springMVC配置结束 -->

           <welcome-file-list>
               <welcome-file>index.jsp</welcome-file>
           </welcome-file-list>
       </web-app>
   ```

四、新建包名:com.jk.controller,新建User.java;
--------------------
   ```
       package com.jk.controller;

       import org.springframework.stereotype.Controller;
       import org.springframework.web.bind.annotation.RequestMapping;
       import org.springframework.web.bind.annotation.RequestMethod;
       import org.springframework.web.bind.annotation.ResponseBody;

       @Controller
       @RequestMapping(value = "/user")
       public class User {

           @RequestMapping(value = "/register", method = RequestMethod.GET)
           @ResponseBody
           public Object findUserById() {

               return "register";
           }
       }

   ```