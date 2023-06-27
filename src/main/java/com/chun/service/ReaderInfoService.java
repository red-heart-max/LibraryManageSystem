package com.chun.service;


import com.chun.pojo.Impl.ReaderInfoVO;
import com.chun.pojo.ReaderInfo;

import java.util.List;

public interface ReaderInfoService {


    /**
     * 根据用户名和密码查询用户信息
     */
    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);

    /***
     * 更新密码
     * @param reader
     * @param newPwd
     * @return
     */
    int updatePwd(ReaderInfo reader, String newPwd);

    List<ReaderInfo> findAllReader(ReaderInfoVO readerInfoVO);

    ReaderInfo queryReaderInfoById(int id);

    int updateReader(ReaderInfo readerInfo);

    int addReader(ReaderInfo readerInfo);

    int deleteReader(String id);

    ReaderInfo selectIdByNumber(String readerNumber);

    int updateFace(ReaderInfo user);
}

