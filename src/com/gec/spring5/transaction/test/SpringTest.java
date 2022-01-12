package com.gec.spring5.transaction.test;

import com.gec.spring5.transaction.config.SpringConfig;
import com.gec.spring5.transaction.entity.User;
import com.gec.spring5.transaction.entity.UserGeneric;
import com.gec.spring5.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.math.BigInteger;
import java.util.ArrayList;

public class SpringTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = (User) applicationContext.getBean("User");
        User user2 = (User) applicationContext.getBean("User");
        UserService userServiceImpl = (UserService) applicationContext.getBean("UserServiceImpl");
        user.setName("xiaozhang");user.setMoney(new BigInteger("1000"));
        user2.setName("xiaotian");user2.setMoney(new BigInteger("1000"));
        userServiceImpl.batchUser(new ArrayList<Object[]>(){{
            add(new Object[]{
                    user.getName(),
                    user.getMoney()
            });
            add(new Object[]{
                    user2.getName(),
                    user2.getMoney()
            });
        }});
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userServiceImpl = (UserService) applicationContext.getBean("UserServiceImpl");
        userServiceImpl.findUser();
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userServiceImpl = (UserService) applicationContext.getBean("UserServiceImpl");
        User user = (User) applicationContext.getBean("User");
        User user2 = (User) applicationContext.getBean("User");
        user.setName("xiaozhang");user.setMoney(new BigInteger("100"));
        user2.setName("xiaotian");user2.setMoney(new BigInteger("100"));
        userServiceImpl.transfer(user, user2);
    }

    @Test
    public void testGenericApplicationContext(){
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.refresh();
        genericApplicationContext.registerBean("UserGeneric",UserGeneric.class, () -> new UserGeneric());

        UserGeneric bean = (UserGeneric) genericApplicationContext.getBean("UserGeneric");
        System.out.println(bean);
    }
}
