package com.example.securityproject.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.securityproject.pojo.UserDTO;
import com.example.securityproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: SecurityProject
 * @description: 用户控制层
 * @author: kangwei
 * @create: 2023-02-15 22:48
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     *
     * @return
     */
    @GetMapping("/getUserList")
    public List<UserDTO> getUserList() {
        return userService.getUserList();
    }

    /**
     * 分页查询用户信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getUserByPage/{pageNum}/{pageSize}")
    public IPage<UserDTO> getUserByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return userService.getUserByPage(pageNum, pageSize);
    }

    /**
     * 保存用户信息
     *
     * @param userDTO
     */
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    /**
     * 更新用户信息
     *
     * @param userDTO
     */
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param userId
     */
    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
    }

    /**
     * 根据id查询用户信息
     *
     * @param userId
     */
    @GetMapping("/getUserById/{userId}")
    public void getUserById(@PathVariable String userId) {
        userService.getUserById(userId);
    }
}
