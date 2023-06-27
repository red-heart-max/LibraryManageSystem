package com.chun.service.impl;

import com.chun.dao.TypeInfoMapper;
import com.chun.pojo.Impl.TypeVO;
import com.chun.pojo.ReaderInfo;
import com.chun.pojo.Type;
import com.chun.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeInfoServiceImpl implements TypeInfoService {
    @Autowired
    private TypeInfoMapper typeInfoMapper;
    @Override
    public List<Type> findAllType(TypeVO typeVO) {
        return typeInfoMapper.findAllType(typeVO);
    }

    @Override
    public int addType(Type type) {
        return typeInfoMapper.addType(type);
    }

    @Override
    public Type queryReaderInfoById(int id) {
        return typeInfoMapper.queryReaderInfoById(id);
    }

    @Override
    public int updateReader(Type type) {
        return typeInfoMapper.updateReader(type);
    }

    @Override
    public int deleteType(String id) {
        return typeInfoMapper.deleteType(id);
    }
}
