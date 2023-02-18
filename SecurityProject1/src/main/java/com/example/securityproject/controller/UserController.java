package com.example.securityproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }

}
