package com.chun.service;

import com.chun.pojo.Impl.LendBookOV;
import com.chun.pojo.LendBook;

import java.util.List;

public interface LendBookService {
    List<LendBook> selectAllBook(LendBookOV lendBookOV);
    List<LendBook> selectBook(LendBookOV lendBookOV);

    int deleteLend(String id);

    int addLendList(LendBook lendBook);

    LendBook selectListById(int id);

    int updateList1(LendBook lendBook);
    int updateList2(LendBook lendBook);
}
