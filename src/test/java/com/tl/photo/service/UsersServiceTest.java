package com.tl.photo.service;

import com.tl.photo.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author tl
 * @Date 2021/10/17 4:16 下午
 * @Version 1.0
 */
@SpringBootTest
class UsersServiceTest {
    @Autowired
    private UsersService usersService;

    @Test
    void findAllUsers() {
        List<Users> allUsers = usersService.findUsersAll();
        for (Users users:
             allUsers) {
            System.out.println(users);
        }
    }
}