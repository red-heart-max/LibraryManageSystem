package com.chun.service;


import com.chun.pojo.UserFace;

import javax.servlet.http.HttpServletRequest;

public interface FaceService {

    public int addUserFace(UserFace userFace);
    public int validateUserToken(UserFace userFace);
//
    public String faceRecognize(StringBuffer imageBase64, String userToken, String type, HttpServletRequest request);
}
