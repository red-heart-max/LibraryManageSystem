package com.chun.dao;

import com.chun.pojo.Impl.LendBookOV;
import com.chun.pojo.LendBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LendBookMapper {
    List<LendBook> selectAllBook(LendBookOV lendBookOV);

    int deleteLend(String id);

    int addLendList(LendBook lendBook);

    LendBook selectListById(int id);

    int updateList1(LendBook lendBook);
    int updateList2( LendBook lendBook);

    List<LendBook> selectBook(LendBookOV lendBookOV);
}
