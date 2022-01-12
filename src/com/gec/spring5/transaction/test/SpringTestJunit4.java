package com.gec.spring5.transaction.test;

import com.gec.spring5.transaction.entity.User;
import com.gec.spring5.transaction.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringTestJunit4 {

    @Autowired
    private UserService userService;

    @Autowired
    private User user;

    @Test
    public void test() {
        System.out.println(user);
    }

}
