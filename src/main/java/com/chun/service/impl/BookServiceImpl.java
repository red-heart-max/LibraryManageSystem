package com.chun.service.impl;

import com.chun.dao.BookMapper;
import com.chun.pojo.Book;
import com.chun.pojo.Impl.BookVO;
import com.chun.pojo.Impl.LendBookOV;
import com.chun.pojo.LendBook;
import com.chun.pojo.Type;
import com.chun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Type> findAllList() {
        return bookMapper.findAllList();
    }

//    @Override
//    public List<Book> findAllBook() {
//        return bookMapper.findAllBook();
//    }

    @Override
    public List<Book> findAllBook(BookVO bookVO) {
        return bookMapper.findAllBook(bookVO);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public Book queryBookInfoBy(int id) {
        return bookMapper.queryBookInfoBy(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public int lendBook(String i) {
       return bookMapper.lendBook(i);
    }

    @Override
    public void selectBookById(Integer bookId) {
        bookMapper.selectBookById(bookId);
    }

    @Override
    public List<LendBook> bookStatus(LendBook book) {
        return bookMapper.bookStatus(book);
    }
}
