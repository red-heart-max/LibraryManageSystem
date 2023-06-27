package com.chun.pojo;

public class UserFace {
    private int id;
    private String  userToken;
    private String userFaceBase64;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserFaceBase64() {
        return userFaceBase64;
    }

    public void setUserFaceBase64(String userFaceBase64) {
        this.userFaceBase64 = userFaceBase64;
    }
}
