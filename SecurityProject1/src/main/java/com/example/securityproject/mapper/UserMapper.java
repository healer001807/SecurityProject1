package com.example.securityproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.securityproject.pojo.RoleDTO;
import com.example.securityproject.pojo.UserDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: SecurityProject1
 * @description:
 * @author: kangwei
 * @create: 2023-02-15 23:08
 **/
@Repository
public interface UserMapper extends BaseMapper<UserDTO> {

    /**
     * 根据用户id查询用户角色
     *
     * @param userId
     * @return
     */
    @Select("SELECT t1.role_id ,t.role_name FROM t_role t ,t_role_user t1 WHERE t.role_id = t1.role_id and  t1.user_id = #{userId}")
    List<RoleDTO> getRoleListByUserId(String userId);
}
