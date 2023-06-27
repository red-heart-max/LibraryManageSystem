package com.chun.service;

import com.chun.pojo.Book;
import com.chun.pojo.Impl.BookVO;
import com.chun.pojo.Impl.LendBookOV;
import com.chun.pojo.LendBook;
import com.chun.pojo.Type;


import java.util.List;

public interface BookService {
    List<Type> findAllList();

//    List<Book> findAllBook();
    List<Book> findAllBook(BookVO bookVO);

    int addBook(Book book);

    int deleteBook(int id);

    Book queryBookInfoBy(int id);

    int updateBook(Book book);

    int lendBook(String i);

    void selectBookById(Integer bookId);

    List<LendBook> bookStatus(LendBook book);

}
