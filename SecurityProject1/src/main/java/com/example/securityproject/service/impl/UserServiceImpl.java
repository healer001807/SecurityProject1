package com.example.securityproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.securityproject.mapper.UserMapper;
import com.example.securityproject.pojo.UserDTO;
import com.example.securityproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @program: SecurityProject1
 * @description:用户业务实现
 * @author: kangwei
 * @create: 2023-02-18 15:12
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserDTO> getUserList() {
        return userMapper.selectList(null);
    }

    @Override
    public UserDTO getUserById(String userId) {
        Assert.notNull(userId);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userMapper.insert(userDTO);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Assert.notNull(userDTO.getUserId());
        userMapper.updateById(userDTO);

    }

    @Override
    public void deleteUserById(String userId) {
        Assert.notNull(userId);
        userMapper.deleteById(userId);
    }

    @Override
    public IPage<UserDTO> getUserByPage(int pageNum, int pageSize) {
        IPage<UserDTO> iPage = new Page<>(pageNum, pageSize);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage page = userMapper.selectPage(iPage, queryWrapper);
        return page;
    }
}
