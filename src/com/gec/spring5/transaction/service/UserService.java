package com.gec.spring5.transaction.service;

import com.gec.spring5.transaction.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUser();

    void batchUser(List<Object[]> list);

    void addMoney(User user);

    void decrementMoney(User user);

    void transfer(User user,User user2);
}
