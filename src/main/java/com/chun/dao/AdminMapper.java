package com.chun.dao;


import com.chun.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    /**
     * 根据用户名和密码查询用户信息
     */
    Admin queryUserByNameAndPassword(@Param("username") String username, @Param("password") String password);

    int updatePwd(Admin manager);

    int updateFace(Admin user);
}