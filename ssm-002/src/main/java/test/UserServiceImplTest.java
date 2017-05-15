package test;

import com.store.model.User;
import com.store.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Handsome on 2017/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class UserServiceImplTest {
    @Resource
    private UserServiceImpl service;

    @Test
    public void testFindUser1() throws Exception {
        System.out.println("******************");
        User user=new User();
        user.setId(1l);
        user.setUsername("大神");
        user.setPassword("123456");
        user.setAge(18);
        System.out.println(service.findUser3(user));
        System.out.println("******************");
    }
}