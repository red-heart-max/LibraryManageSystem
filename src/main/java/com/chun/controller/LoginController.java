package com.chun.controller;


import com.chun.codeutil.IVerifyCodeGen;
import com.chun.codeutil.SimpleCharVerifyCodeGenImpl;
import com.chun.codeutil.VerifyCode;
import com.chun.pojo.Admin;
import com.chun.pojo.ReaderInfo;
import com.chun.service.AdminService;
import com.chun.service.ReaderInfoService;
import com.chun.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ReaderInfoService readerService;
    /**
     * 登录页面的转发
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 获取验证码方法
     * @param request
     * @param response
     */
    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
//            System.out.println(1);
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            //将VerifyCode绑定session
//            System.out.println(2);
            request.getSession().setAttribute("VerifyCode", code);

            //设置响应头
//            System.out.println(3);
            response.setHeader("Pragma", "no-cache");
            //设置响应头
//            System.out.println(4);
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
//            System.out.println(5);
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
//            System.out.println(6);
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
//            System.out.println(7);
        } catch (IOException e) {
            System.out.println("异常处理");
        }
    }

    /**
     * 登录验证
     */
    @RequestMapping("/loginIn")
    public String loginIn(HttpServletRequest request, Model model){
        //获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code=request.getParameter("captcha");
        String type=request.getParameter("type");

        //判断验证码是否正确（验证码已经放入session）
        HttpSession session = request.getSession();
        String realCode = (String)session.getAttribute("VerifyCode");
        if (!realCode.toLowerCase().equals(code.toLowerCase())){
            model.addAttribute("msg","验证码不正确");
            return "login";
        }else{
            //验证码正确则判断用户名和密码
            if(type.equals("1")){//管理员信息
                //用户名和密码是否正确
                Admin admin=adminService.queryUserByNameAndPassword(username,password);
                if(admin==null){//该用户不存在
                    model.addAttribute("msg","用户名或密码错误");
                    return "login";
                }
                session.setAttribute("user",admin);
                session.setAttribute("type","admin");
            }else{//来自读者信息表
                ReaderInfo readerInfo=readerService.queryUserInfoByNameAndPassword(username,password);
                if(readerInfo==null){
                    model.addAttribute("msg","用户名或密码错误");
                    return "login";
                }
                session.setAttribute("user",readerInfo);
                session.setAttribute("type","reader");
            }

            return "index";
        }
    }
    /**
     * 退出功能
     */
    @GetMapping("loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();//注销
        return "/login";
    }
    /**
     * 修改密码
     */
    @ResponseBody
    @RequestMapping(value = "/updatePwdSubmit2")
    public ServerResponse updatePwd(String oldPwd,String newPwd,HttpServletRequest req){
        String type = (String) req.getSession().getAttribute("type");
        System.out.println(type);
        if (type.equals("admin")){
            Admin manager = (Admin) req.getSession().getAttribute("user");
            System.out.println(manager);
            Admin admin = adminService.queryUserByNameAndPassword(manager.getUsername(), oldPwd);
//            System.out.println(admin);
            if (admin!=null){
                int i = adminService.updatePwd(manager, newPwd);
                if (i>0){
                    return ServerResponse.createBySuccess("修改成功");
                }else {
                    return ServerResponse.createByError("修改失败");
                }
            }else {
                return ServerResponse.createByError("密码错误");
            }
        }else {
            ReaderInfo reader = (ReaderInfo) req.getSession().getAttribute("user");
            System.out.println(reader);
            ReaderInfo readerInfo = readerService.queryUserInfoByNameAndPassword(reader.getUsername(), oldPwd);
            if (readerInfo!=null){
                int i = readerService.updatePwd(readerInfo, newPwd);
                if (i>0){
                    return ServerResponse.createBySuccess("修改成功");
                }else {
                    return ServerResponse.createByError("修改失败");
                }
            }else {
                return ServerResponse.createByError("密码错误");
            }
        }

    }
}
