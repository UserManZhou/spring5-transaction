package com.gec.spring5.transaction.test;

import com.gec.spring5.transaction.config.SpringConfig;
import com.gec.spring5.transaction.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = SpringConfig.class)
@SpringJUnitConfig(classes = SpringConfig.class)
class SpringTestJunit5Test {

    @Autowired
    User user;

    @Test
    public void test(){
        System.out.println(user);
    }

}