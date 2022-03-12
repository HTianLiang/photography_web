package com.tl.photo.service.impl;

import com.tl.photo.domain.Users;
import com.tl.photo.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author tl
 * @Date 2021/10/17 3:28 下午
 * @Version 1.0
 */
@SpringBootTest
class UsersServiceImplTest {
    @Autowired
    private UsersService usersService;

    @Test
    void addUser() {
        List<Users> usersList = new ArrayList<>();
        Users users = new Users();
        users.setUsername("abc456");
        users.setPassword("123");
        users.setName("ccc");
        usersList.add(users);
        usersService.addUser(usersList);
        System.out.println("success");
    }

}