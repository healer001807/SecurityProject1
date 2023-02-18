package com.example.securityproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SecurityProject1
 * @description: 管理员控制层
 * @author: kangwei
 * @create: 2023-02-16 20:50
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/getUser")
    public String getUser() {
        return "system";
    }
}
