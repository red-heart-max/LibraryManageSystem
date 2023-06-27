package com.chun.controller;

import com.chun.pojo.Book;
import com.chun.pojo.Impl.BookVO;
import com.chun.pojo.Type;
import com.chun.service.BookService;
import com.chun.utils.ServerResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookInfoController {

    @Autowired
    private BookService bookService;

    /**
     * 图书管理首页
     * @return
     */
    @GetMapping("/bookIndex")
    public String bookIndex(){
        return "book/bookIndex";
    }

    /**
     * 图书分类
     * @return
     */
    @ResponseBody
    @GetMapping("/findAllList")
    public ServerResponse<List<Type>> findAllBookList(){
        List<Type> list = bookService.findAllList();
//        System.out.println(list);
        return ServerResponse.createBySuccess("查询成功",list,list.size());
    }
    /**
     * 查询所有图书
     */
    @ResponseBody
    @GetMapping("/bookAll")
    public ServerResponse<List<Book>> findAllBook(BookVO bookVO){
        PageHelper.startPage(bookVO.getPage(),bookVO.getLimit());
        List<Book> list = bookService.findAllBook(bookVO);
//        System.out.println(list);
        PageInfo<Book> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("查询成功",pageInfo.getList(),pageInfo.getTotal());
    }
    /**
     * 添加图书
     */
    @ResponseBody
    @RequestMapping(value = "/addBookSubmit")
    public ServerResponse<Object> addBook(Book book){
//        System.out.println("添加进入后端 "+book);
        int i = bookService.addBook(book);
//        System.out.println(i);
        if (i>0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByError("添加失败");
    }

    /**
     * 通过id删除图书
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteBook")
    public ServerResponse<Object> deleteBook(String ids){
//        System.out.println(ids);
        String id[]=ids.split(",");
        int y=0;
        for (String i:id) {
            int x = bookService.deleteBook(Integer.parseInt(i));
            y+=x;
        }
        if (y>0){
            return ServerResponse.createBySuccess("删除成功",y,y);
        }
        return ServerResponse.createByError("删除失败");
    }
    /**
     * 修改图书
     *
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/updateBookSubmit")
//    public ServerResponse<Object> queryBookInfoById(String json){
//        System.out.println(json);
//        Book book = JsonUtil.parseObject(json, Book.class);
//        int i = bookService.updateBook(book);
//        System.out.println(i);
//        if (i>0){
//            return ServerResponse.createBySuccess("修改成功");
//        }
//        return ServerResponse.createByError("修改失败");
//    }
    @ResponseBody
    @RequestMapping("/updateBookSubmit")
    public ServerResponse<Object> updateBook(Book book){
        System.out.println(book);
        int i = bookService.updateBook(book);
        System.out.println(i);
        if (i>0){
            return ServerResponse.createBySuccess("修改成功");
        }
        return ServerResponse.createByError("修改失败");
    }
    /**
     * 模糊查询图书
     */
    @RequestMapping(value = "/searchBook",method = RequestMethod.GET)
    public void searchBook(Book book){
        System.out.println(book);
    }
}
