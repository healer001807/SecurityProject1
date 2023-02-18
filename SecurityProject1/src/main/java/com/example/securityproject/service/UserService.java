package com.example.securityproject.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.securityproject.pojo.UserDTO;

import java.util.List;

/**
 * @program: SecurityProject1
 * @description: 用户业务接口
 * @author: kangwei
 * @create: 2023-02-18 15:11
 **/
public interface UserService {

    /**
     * 查询用户
     *
     * @return
     */
    List<UserDTO> getUserList();

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    UserDTO getUserById(String userId);

    /**
     * 添加用户
     *
     * @param userDTO
     */
    void saveUser(UserDTO userDTO);

    /**
     * 更新用户
     *
     * @param userDTO
     */
    void updateUser(UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteUserById(String userId);

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<UserDTO> getUserByPage(int pageNum,int pageSize);
}
