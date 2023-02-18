package com.example.securityproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.securityproject.constant.MessageConstant;
import com.example.securityproject.mapper.UserMapper;
import com.example.securityproject.pojo.RoleDTO;
import com.example.securityproject.pojo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: SecurityProject
 * @description: 用户权限验证
 * @author: kangwei
 * @create: 2023-02-15 22:38
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    private static final GrantedAuthority GRANTED_AUTHORITY = new SimpleGrantedAuthority("USER"); //普通用户角色

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户是否存在
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", username);
        UserDTO userDTO = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(userDTO)) {
            throw new UsernameNotFoundException(MessageConstant.USER_NOT_EMPTY);
        }

        // 查询用户角色
        List<RoleDTO> roleDTOS = userMapper.getRoleListByUserId(userDTO.getUserId());

        // 初始化角色
        List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
//
        if (CollectionUtils.isEmpty(roleDTOS)) {
            grantedAuthorities.add(GRANTED_AUTHORITY);
        }
        for (RoleDTO roleDTO : roleDTOS) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleDTO.getRoleName());
            grantedAuthorities.add(grantedAuthority); // todo
        }
        return new User(userDTO.getUserName(), userDTO.getUserPwd(), grantedAuthorities);
    }
}
