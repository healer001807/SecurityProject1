package com.example.securityproject.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "user_id",type = IdType.AUTO) // 主键
    private String userId;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "user_pwd")
    private String userPwd;
}
