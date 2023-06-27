package com.chun.service;


import com.chun.pojo.Admin;

public interface AdminService {


    /**
     * 根据用户名和密码查询用户信息
     */
    Admin queryUserByNameAndPassword(String username, String password);

    int updatePwd(Admin manager, String newPwd);

    int updateFace(Admin user);
}
