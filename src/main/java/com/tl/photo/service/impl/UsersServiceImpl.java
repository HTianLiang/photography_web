package com.tl.photo.service.impl;

import com.tl.photo.domain.Users;
import com.tl.photo.mapper.UsersMapper;
import com.tl.photo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/10/17 3:24 下午
 * @Version 1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUser(List<Users> usersList) {
        usersMapper.addUser(usersList);
    }

    @Override
    public List<Users> findUsersAll() {
        return usersMapper.findUsersAll();
    }

    @Override
    public Users findByUsernameAndPassword(String username, String password) {
        return usersMapper.findByUsernameAndPassword(username, password);
    }

    @Override
    public Users findByUsername(String username) {
        return usersMapper.findByUsername(username);
    }

    @Override
    public Users findByUsersId(Integer userId) {
        return usersMapper.findByUsersId(userId);
    }

    @Override
    public void updateInfo(Users users) {
        usersMapper.updateInfo(users);
    }
}
