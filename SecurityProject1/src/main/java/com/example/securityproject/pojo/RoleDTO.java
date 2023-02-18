package com.example.securityproject.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: SecurityProject1
 * @description: 角色表
 * @author: kangwei
 * @create: 2023-02-16 22:13
 **/
@Data
@TableName("t_role")
public class RoleDTO {
    private String roleId;
    private String roleName;
}
