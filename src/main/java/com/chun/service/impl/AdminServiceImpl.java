package com.chun.service.impl;


import com.chun.dao.AdminMapper;
import com.chun.pojo.Admin;
import com.chun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin queryUserByNameAndPassword(String username, String password) {
        return adminMapper.queryUserByNameAndPassword(username,password);
    }

    @Override
    public int updatePwd(Admin manager, String newPwd) {
        manager.setPassword(newPwd);
        return adminMapper.updatePwd(manager);
    }

    @Override
    public int updateFace(Admin user) {
        return adminMapper.updateFace(user);
    }
}
