package com.chun.dao;

import com.chun.pojo.Admin;
import com.chun.pojo.ReaderInfo;
import com.chun.pojo.UserFace;

import java.util.Map;

public interface FaceMapper {
    public int addUserFace(UserFace userFace);
//
//
    public Map<String,Long> getCountByToken(UserFace userFace);


//    public UserFace getUserByToken(String userToken);
    public Admin getUserByAdmin(String userToken);
    public ReaderInfo getUserByReader(String userToken);


}
