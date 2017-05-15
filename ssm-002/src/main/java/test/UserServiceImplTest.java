package test;

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
        System.out.println(service.findUserByID(1l));
        System.out.println("******************");
    }
}