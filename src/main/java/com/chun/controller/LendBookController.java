package com.chun.controller;

import com.chun.pojo.Impl.LendBookOV;
import com.chun.pojo.LendBook;
import com.chun.pojo.ReaderInfo;
import com.chun.service.BookService;
import com.chun.service.LendBookService;
import com.chun.service.ReaderInfoService;
import com.chun.utils.ServerResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class LendBookController {
    @Autowired
    private LendBookService lendBookservice;

    @Autowired
    private ReaderInfoService readerInfoService;

    @Autowired
    private BookService bookService;
    @Autowired
    private LendBook lendBook;

    /**
     *  table.render 数据表格
     * @param bookOV
     * @return
     */
    @ResponseBody
    @RequestMapping("/allBook.do")
    public ServerResponse selectAllBook(LendBookOV bookOV){
        System.out.println(bookOV);
        PageHelper.startPage(bookOV.getPage(),bookOV.getLimit());
        List<LendBook> list=lendBookservice.selectAllBook(bookOV);
        PageInfo<LendBook> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return ServerResponse.createBySuccess("查询成功",pageInfo.getList(),pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("/bookAll.do")
    public ServerResponse bookAll(LendBookOV bookOV){
        PageHelper.startPage(bookOV.getPage(),bookOV.getLimit());
        List<LendBook> list = bookService.bookStatus(bookOV);
        PageInfo<LendBook> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return ServerResponse.createBySuccess("查询成功",pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 删除借阅记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteLend.do")
    public ServerResponse<Object> deleteLend(String ids){
        System.out.println(ids);
        String arr[]=ids.split(",");
        int i=0;
        for (String id:arr
             ) {
            i+=lendBookservice.deleteLend(id);
        }
        if (i>0){
            return ServerResponse.createBySuccess("删除成功",i,i);
        }
        return ServerResponse.createByError("删除失败");
    }
    /**
     * 借书
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addLendList")
    public ServerResponse<Object> addLendList(String readerNumber, String idss){
//        找到借阅人id
        ReaderInfo reader=readerInfoService.selectIdByNumber(readerNumber);
        Integer id = reader.getId();
//        图书状态改为1
        String[] ids =idss.split(",");

        int x=0;
        for (String i:ids
             ) {
            int j = bookService.lendBook(i);
//            书的id
            lendBook.setBookId(Integer.valueOf(i));
//            借阅人id
            lendBook.setReaderId(id);

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            lendBook.setLendDate(timestamp);
            x+= lendBookservice.addLendList(lendBook);
        }
        if (x>0){
            return ServerResponse.createBySuccess("借阅成功");
        }
        return ServerResponse.createByError("借阅失败");
    }
    /**
     * 异常还书
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/excBackBook")
    public ServerResponse<Integer> excBackBook(LendBook lendBook){
        Integer bookId = lendBook.getBookId();
        //将书的status设置为0
        bookService.selectBookById(bookId);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        lendBook.setBackDate(timestamp);
        int i=lendBookservice.updateList1(lendBook);
        if (i>0){
            return ServerResponse.createBySuccess("还书成功",i,i);
        }
        return ServerResponse.createByError("还书失败");
    }
    /**
     * 正常还书
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/backBook.do")
    public ServerResponse<Integer> BackBook(String ids){
//        System.out.println(ids);
        String id[]=ids.split(",");
        int i=0;
        for (String x:id
             ) {

            LendBook lendBook1 = lendBookservice.selectListById(Integer.parseInt(x));
            System.out.println(lendBook1);
//            设置书的status
            bookService.selectBookById(lendBook1.getBookId());

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            lendBook.setBackDate(timestamp);
            lendBook.setBackType("0");
            lendBook.setId(lendBook1.getId());
            i+=lendBookservice.updateList2(lendBook);
        }
        System.out.println(i);
        if (i>0){
            return ServerResponse.createBySuccess("还书成功",i,i);
        }
        return ServerResponse.createByError("还书失败");
    }
}
