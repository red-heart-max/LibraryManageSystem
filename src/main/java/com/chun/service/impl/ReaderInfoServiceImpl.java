package com.chun.service.impl;


import com.chun.dao.ReaderInfoMapper;
import com.chun.pojo.Impl.ReaderInfoVO;
import com.chun.pojo.ReaderInfo;
import com.chun.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("readerInfoService")
public class ReaderInfoServiceImpl implements ReaderInfoService {

    @Autowired
    private ReaderInfoMapper readerInfoMapper;


    @Override
    public ReaderInfo queryUserInfoByNameAndPassword(String username, String password) {
        return readerInfoMapper.queryUserInfoByNameAndPassword(username, password);
    }

    @Override
    public int updatePwd(ReaderInfo reader, String newPwd) {
        reader.setPassword(newPwd);
        return readerInfoMapper.updatePwd(reader);
    }

    @Override
    public List<ReaderInfo> findAllReader(ReaderInfoVO readerInfoVO) {
        return readerInfoMapper.findAllReader(readerInfoVO);
    }

    @Override
    public ReaderInfo queryReaderInfoById(int id) {
        return readerInfoMapper.queryReaderInfoById(id);
    }

    @Override
    public int updateReader(ReaderInfo readerInfo) {
        return readerInfoMapper.updateReader(readerInfo);
    }

    @Override
    public int addReader(ReaderInfo readerInfo) {
        return readerInfoMapper.addReader(readerInfo);
    }

    @Override
    public int deleteReader(String id) {
        return readerInfoMapper.deleteReader(id);
    }

    @Override
    public ReaderInfo selectIdByNumber(String readerNumber) {
        return readerInfoMapper.selectIdByNumber(readerNumber);
    }

    @Override
    public int updateFace(ReaderInfo user) {
        return readerInfoMapper.updateFace(user);
    }
}
