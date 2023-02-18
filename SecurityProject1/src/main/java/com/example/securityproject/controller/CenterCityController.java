package com.example.securityproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SecurityProject1
 * @description: 分中心城市控制层
 * @author: kangwei
 * @create: 2023-02-16 20:48
 **/
@Slf4j
@RestController
@RequestMapping("/centerCity")
public class CenterCityController {

    @GetMapping("/getCenterCity")
    public String getCenterCity() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = principal.toString();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        }
        log.info("用户信息:" + userName);
        return "南京市";
    }
}
