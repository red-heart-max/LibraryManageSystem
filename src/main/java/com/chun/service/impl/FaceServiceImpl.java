package com.chun.service.impl;


import com.chun.dao.FaceMapper;
import com.chun.entity.WebFaceCompare;
import com.chun.pojo.Admin;
import com.chun.pojo.ReaderInfo;
import com.chun.pojo.UserFace;
import com.chun.service.FaceService;
import com.chun.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.Map;

@Service
public class FaceServiceImpl implements FaceService {

    @Autowired
    FaceMapper faceDao;


    @Override
    public int addUserFace(UserFace userFace) {
        return faceDao.addUserFace(userFace);
    }

    @Override
    public int validateUserToken(UserFace userFace) {
        Map<String, Long> countByToken = faceDao.getCountByToken(userFace);
        return countByToken.get("count").intValue();
    }
//
    @Override
    public String faceRecognize(StringBuffer imageBase64, String userToken, String type,HttpServletRequest request) {
        String back = "{\n" +
                "\t\"ret\" : 1,\n" +
                "\t\"score\" : 0.86\n" +
                "}";
        Admin admin=null;
        ReaderInfo readerInfo=null;
//        System.out.println(type);
        HttpSession session = request.getSession();

        if (type.equals("1")){
            admin=faceDao.getUserByAdmin(userToken);
            System.out.println(admin);
            if(admin!=null){
                session.setAttribute("user",admin);
                session.setAttribute("type","admin");
                WebFaceCompare demo = new WebFaceCompare();
                WebFaceCompare.ResponseData respData = null;
                try {
                    respData = demo.faceContrastImageBase64(imageBase64.toString(), admin.getUserFaceBase64());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (respData != null && respData.getPayLoad().getFaceCompareResult() != null) {
                    String textBase64 = respData.getPayLoad().getFaceCompareResult().getText();
                    String text = new String(Base64.getDecoder().decode(textBase64));
                    System.out.println("人脸比对结果(text)base64解码后：");
                    System.out.println(text);
                    back = text;
                }
            }
        }else if (type.equals("2")){
            readerInfo=faceDao.getUserByReader(userToken);
            if (readerInfo!=null) {
                session.setAttribute("user",readerInfo);
                session.setAttribute("type","reader");
                WebFaceCompare demo = new WebFaceCompare();
                WebFaceCompare.ResponseData respData = null;
                try {
                    respData = demo.faceContrastImageBase64(imageBase64.toString(), readerInfo.getUserFaceBase64());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (respData != null && respData.getPayLoad().getFaceCompareResult() != null) {
                    String textBase64 = respData.getPayLoad().getFaceCompareResult().getText();
                    String text = new String(Base64.getDecoder().decode(textBase64));
                    System.out.println("人脸比对结果(text)base64解码后：");
                    System.out.println(text);
                    back = text;
                }
            }
        }
//        UserFace savedUserFace = faceDao.getUserByToken(userToken);
//        if(savedUserFace!=null){
//            WebFaceCompare demo = new WebFaceCompare();
//            WebFaceCompare.ResponseData respData = null;
//            try {
//                respData = demo.faceContrastImageBase64(imageBase64.toString(), savedUserFace.getUserFaceBase64());
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//            if (respData != null && respData.getPayLoad().getFaceCompareResult() != null) {
//                String textBase64 = respData.getPayLoad().getFaceCompareResult().getText();
//                String text = new String(Base64.getDecoder().decode(textBase64));
//                System.out.println("人脸比对结果(text)base64解码后：");
//                System.out.println(text);
//                back = text;
//            }
//        }

        return GsonUtils.toJson(back);
    }
}
