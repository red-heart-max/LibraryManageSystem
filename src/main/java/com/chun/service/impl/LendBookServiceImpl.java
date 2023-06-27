package com.chun.service.impl;

import com.chun.dao.LendBookMapper;
import com.chun.pojo.Impl.LendBookOV;
import com.chun.pojo.LendBook;
import com.chun.service.LendBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendBookServiceImpl implements LendBookService {
    @Autowired
    private LendBookMapper lendBookMapper;

    @Override
    public List<LendBook> selectAllBook(LendBookOV lendBookOV) {
        return lendBookMapper.selectAllBook(lendBookOV);
    }

    @Override
    public List<LendBook> selectBook(LendBookOV lendBookOV) {
        return lendBookMapper.selectBook(lendBookOV);
    }

    @Override
    public int deleteLend(String id) {
        return lendBookMapper.deleteLend(id);
    }

    @Override
    public int addLendList(LendBook lendBook) {
        return lendBookMapper.addLendList(lendBook);
    }

    @Override
    public LendBook selectListById(int id) {
        return lendBookMapper.selectListById(id);
    }

    @Override
    public int updateList1(LendBook lendBook) {
        return lendBookMapper.updateList1(lendBook);
    }

    @Override
    public int updateList2(LendBook lendBook) {
        return lendBookMapper.updateList2(lendBook);
    }
}
