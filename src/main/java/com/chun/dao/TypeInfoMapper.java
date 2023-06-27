package com.chun.dao;

import com.chun.pojo.Impl.TypeVO;
import com.chun.pojo.ReaderInfo;
import com.chun.pojo.Type;

import java.util.List;

public interface TypeInfoMapper {

    List<Type> findAllType(TypeVO typeVO);

    int addType(Type type);

    Type queryReaderInfoById(int id);

    int updateReader(Type type);

    int deleteType(String id);
}
