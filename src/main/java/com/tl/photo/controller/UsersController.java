package com.tl.photo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tl.photo.config.VerifyCode;
import com.tl.photo.domain.Users;
import com.tl.photo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author tl
 * @Date 2021/10/17 3:59 下午
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 测试
     */
    @RequestMapping("/testAdd")
    public void addUser(){
        List<Users> usersList = new ArrayList<>();
        Users users = new Users();
        users.setUsername("abc456");
        users.setPassword("123");
        users.setName("ccc");
        usersList.add(users);
        usersService.addUser(usersList);
    }

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @GetMapping("/findByUsername/{username}")
    public Users findByUsername(@PathVariable("username") String username) {
        return usersService.findByUsername(username);
    }

    /**
     * 根据用户id查询用户信息
     * @param usersId
     * @return
     */
    @GetMapping("/findByUsersId/{usersId}")
    public Users findByUsersId(@PathVariable("usersId") Integer usersId) {
        return usersService.findByUsersId(usersId);
    }

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("/findUsersAll")
    public List<Users> findUsersAll() {
        return usersService.findUsersAll();
    }

    /**
     * 修改个人信息
     * @param users
     */
    @PutMapping("/updateInfo")
    public void updateInfo(@RequestBody Users users) {
        usersService.updateInfo(users);
    }

}
