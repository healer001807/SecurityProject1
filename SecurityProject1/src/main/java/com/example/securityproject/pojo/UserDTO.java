package com.example.securityproject.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: SecurityProject
 * @description: 用户实体
 * @author: kangwei
 * @create: 2023-02-15 22:37
 **/
@Data
@TableName("t_user")
public class UserDTO {
    private String userId;
    private String userName;
    private String userPwd;
}
