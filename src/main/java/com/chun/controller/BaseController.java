package com.chun.controller;

import com.chun.pojo.*;
import com.chun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BaseController {

//    @Autowired
//    private NoticeService noticeService;
    @Autowired
        private BookService bookService;
    @Autowired
        private ReaderInfoService readerInfoService;

    @Autowired
        private TypeInfoService typeInfoService;
    @Autowired
    private LendBookService lendBookService;
    @Autowired
    private AnalysisService analysisService;
    @Autowired
    private NoticeService noticeService;
    /**
     * 首页
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/queryLookBookList2")
    public String queryLookBookList2(){
        return "lend/addLendList";
    }
    /**
     * 欢迎页面跳转
     * @return
     */
    @GetMapping("/welcome")
    public String welcome(Model model){
        return "welcome";
    }

    @GetMapping("/updatePassword")
    public String updatePwd(){
        return "pwdUpdate/updatePwd";
    }


    /**
     * 更新图书
     * @return
     */
    @RequestMapping("/queryBookInfoById")
    public String queryBookInfoById(int id, HttpServletRequest request){
//        System.out.println(id);
        Book info = bookService.queryBookInfoBy(id);
//        System.out.println(info);
        request.getSession().setAttribute("info",info);
        return "book/updateBook";
    }
    /**
     * 添加图书
     */
    @GetMapping("/bookAdd")
    public String addBook(){
        return "book/bookAdd";
    }

    /**
     * 读者首页
     * @return
     */
    @GetMapping("/readerIndex")
    public String readerIndex(){
        return "reader/readerIndex";
    }
    /**
     * 更新读者
     */
    @RequestMapping("/queryReaderInfoById")
    public String queryReaderInfoById(int id, HttpServletRequest request){
//        System.out.println(id);
        ReaderInfo info = readerInfoService.queryReaderInfoById(id);
//        System.out.println(info);
        request.getSession().setAttribute("info",info);
        return "reader/updateReader";
    }
    /**
     * 添加读者
     */
    @GetMapping("/readerAdd")
    public String readerAdd(){
        return "reader/readerAdd";
    }
    /**
     * 类型首页
     */
    @GetMapping("/typeIndex")
    public String typeIndex(){
        return "type/typeIndex";
    }
    /**
     * 添加类型
     */
    @GetMapping("/typeAdd")
    public String typeAdd(){
        return "type/typeAdd";
    }
    /**
     * 类型的编辑功能
     */
    @RequestMapping("/queryTypeInfoById")
    public String queryTypeInfoById(int id, HttpServletRequest request){
//        System.out.println(id);
        Type info = typeInfoService.queryReaderInfoById(id);
//        System.out.println(info);
        request.getSession().setAttribute("info",info);
        return "type/updateType";
    }
    /**
     *
     */
    @GetMapping("/lendListIndex")
    public String lendListIndex(){
        return "lend/lendListIndex";
    }
    /**
     * 添加借书
     */
    @GetMapping("/lendBook.add.do")
    public String lendBookAdd(){
        return "lend/addLendList";
    }
    /**
     * 异常还书
     */
    @GetMapping("/excBackBook.do")
    public String excBackBook(int id,HttpServletRequest req){
        LendBook lendBook=lendBookService.selectListById(id);
        req.getSession().setAttribute("id",id);
        req.getSession().setAttribute("bid",lendBook.getBookId());
        return "lend/excBackBook";
    }
    /**
     * 统计分析
     */
    @GetMapping("/analysis")
    public String analysis(Model model){
        List<Analysis> list =analysisService.typeBook();
        model.addAttribute("list",list);
        return "statistic/analysis";
    }
    /**
     * 统计分析
     */
    @GetMapping("/noticeIndexOfReader")
    public String noticeIndexOfReader(){
        return "notice/noticeIndexOfReader";
    }
    //公告管理---------------------
    //公告主页
    @GetMapping("/noticeIndexOfBack")
    public String noticeIndexOfBack(){
        return "/notice/noticeIndexOfBack";
    }

    @GetMapping("/addNoticepage")
    public String addNotice(){
        return "/notice/noticeAdd";
    }


    @GetMapping("/updateNoticePage")
    public String updateNoticePage(String id,HttpServletRequest request){
        System.out.println(id);
        Notice notice = noticeService.updateNoticePage(id);
        request.getSession().setAttribute("notice",notice);
        return "/notice/updateNotice";
    }



}
