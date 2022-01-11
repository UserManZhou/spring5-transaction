package com.gec.spring5.transaction.service.impl;

import com.gec.spring5.transaction.entity.User;
import com.gec.spring5.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> findUser() {
        String sql = "SELECT * FROM `user`";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(Arrays.toString(query.toArray()));
        return query;
    }

    @Override
    public void batchUser(List<Object[]> list) {
        String sql = "INSERT INTO `user`(`name`,`money`) VALUES (?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void addMoney(User user) {
        String sql = "UPDATE `user` SET `money` = `money`+? WHERE `name` = ?";
        int update = jdbcTemplate.update(sql, user.getMoney(),user.getName());
        System.out.println(update);
    }

    @Override
    public void decrementMoney(User user) {
        String sql = "UPDATE `user` SET `money` = `money`-? WHERE `name` = ?";
        int update = jdbcTemplate.update(sql, user.getMoney(),user.getName());
        System.out.println(update);
    }

    @Override
    public void transfer(User user,User user2) {
        // ��������

        // �������
        addMoney(user);
        try {
            int i = 1/0;
        }catch (Exception exception){

        }
        decrementMoney(user2);
    }
}
