package com.chun.service;

import com.chun.pojo.Impl.TypeVO;
import com.chun.pojo.ReaderInfo;
import com.chun.pojo.Type;

import java.util.List;

public interface TypeInfoService {
    List<Type> findAllType(TypeVO typeVO);

    int addType(Type type);

    Type queryReaderInfoById(int id);

    int updateReader(Type type);

    int deleteType(String id);
}
