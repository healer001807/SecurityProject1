package com.example.securityproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.securityproject.constant.MessageConstant;
import com.example.securityproject.mapper.UserMapper;
import com.example.securityproject.pojo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @program: SecurityProject
 * @description: 用户权限验证
 * @author: kangwei
 * @create: 2023-02-15 22:38
 **/
//@Service
public class DemoUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户是否存在
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName", username);
        UserDTO userDTO = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(userDTO)) {
            throw new UsernameNotFoundException(MessageConstant.USER_NOT_EMPTY);
        }
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,role");

        return new User(userDTO.getUserName(), new BCryptPasswordEncoder().encode(userDTO.getUserPwd()), grantedAuthorities);
    }
}
