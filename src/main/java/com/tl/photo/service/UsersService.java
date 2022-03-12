package com.tl.photo.service;

import com.tl.photo.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/10/17 3:23 下午
 * @Version 1.0
 */
public interface UsersService {
    // 新增用户
    void addUser(List<Users> usersList);
    // 查询全部用户
    List<Users> findUsersAll();
    // 根据用户名和密码查询用户
    Users findByUsernameAndPassword(String username,String password);
    // 根据用户名查询用户
    Users findByUsername(String username);
    // 根据用户id查询
    Users findByUsersId(Integer userId);
    // 修改个人信息
    void updateInfo(Users users);
}
