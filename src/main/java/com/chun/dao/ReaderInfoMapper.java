package com.chun.dao;


import com.chun.pojo.Impl.ReaderInfoVO;
import com.chun.pojo.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderInfoMapper {

    int updateReader(ReaderInfo readerInfo);

    List<ReaderInfo> findAllReader(ReaderInfoVO readerInfoVO);

    /**
     * 根据用户名和密码查询用户信息
     */
    ReaderInfo queryUserInfoByNameAndPassword(@Param("username") String username, @Param("password") String password);

    int updatePwd(ReaderInfo reader);

    ReaderInfo queryReaderInfoById(int id);

    int addReader(ReaderInfo readerInfo);

    int deleteReader(String id);

    ReaderInfo selectIdByNumber(String readerNumber);

    int updateFace(ReaderInfo user);
}