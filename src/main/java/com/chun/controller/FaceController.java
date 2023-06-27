package com.chun.controller;


import com.chun.entity.ServerResponse;
import com.chun.pojo.Admin;
import com.chun.pojo.ReaderInfo;
import com.chun.pojo.UserFace;
import com.chun.service.AdminService;
import com.chun.service.FaceService;
import com.chun.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
//@RequestMapping("/face")
public class FaceController {

    @Autowired
    FaceService faceService;
    @Autowired
    ReaderInfoService readerInfoService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/jumpGetFace")
    public String getFace() {
        return "templates/getFace";
    }

    @RequestMapping("/jumpTakeFace")
    public String takeFace() {
        return "templates/takeFace";
    }

    @RequestMapping("/toIndex")
    public String index() {
        return "templates/index";
    }

    @RequestMapping("/faceRecognize")
    @ResponseBody
    public String faceRecognize(@RequestParam(name = "imageBase64") StringBuffer imageBase64, @RequestParam("userToken") String userToken, @RequestParam("type") String type, HttpServletRequest request) throws IOException {
//        System.out.println(userToken);
//        System.out.println(type);
        return faceService.faceRecognize(imageBase64, userToken,type,request);
    }

    @RequestMapping("/faceSucceed")
    public String faceLoginSucceed() {
//        System.out.println("----------------------------");
        System.out.println("faceSucceed");
        return "index";
    }

    @RequestMapping("/validateUserToken")
    @ResponseBody
    public ServerResponse validateUserToken(UserFace userFace) {
        int i = faceService.validateUserToken(userFace);
        if (i == 0) {
            return ServerResponse.createBySuccess("放心使用", null);

        } else {
            return ServerResponse.createByError("账号已存在");
        }
    }

    @RequestMapping("/saveFaceBase64")
    @ResponseBody
    public ServerResponse saveFace(String userFaceBase64,HttpServletRequest req) {
//        System.out.println(userFaceBase64);
        HttpSession session = req.getSession();
        Object type = session.getAttribute("type");
//        System.out.println(type);
        int i=0;
        if (type.equals("reader")) {
            ReaderInfo user = (ReaderInfo) session.getAttribute("user");

            user.setUserFaceBase64(userFaceBase64);
            i=readerInfoService.updateFace(user);
        }else if (type.equals("admin")){
            Admin user= (Admin) session.getAttribute("user");
            user.setUserFaceBase64(userFaceBase64);
            i=adminService.updateFace(user);
        }
        if (i > 0) {
            return ServerResponse.createBySuccess("保存成功", null);
        } else {
            return ServerResponse.createByError("保存失败");
        }
    }

}
