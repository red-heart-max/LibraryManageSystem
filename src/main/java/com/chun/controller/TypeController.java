package com.chun.controller;

import com.chun.pojo.Impl.TypeVO;
import com.chun.pojo.Type;
import com.chun.service.TypeInfoService;
import com.chun.service.impl.TypeInfoServiceImpl;
import com.chun.utils.ServerResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private TypeInfoService typeInfoService;

    /**
     * 查询所有类别
     * @param typeVO
     * @return
     */
    @ResponseBody
    @GetMapping("/typeAll")
    public ServerResponse typeAll(TypeVO typeVO){
        PageHelper.startPage(typeVO.getPage(),typeVO.getLimit());
        List<Type> list = typeInfoService.findAllType(typeVO);
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("查询成功",pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 添加类别
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping("/addTypeSubmit")
    public ServerResponse addType(Type type){
        int i = typeInfoService.addType(type);
        if (i>0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByError("添加失败");
    }
    /**
     * 编辑类别
     */
    @ResponseBody
    @RequestMapping("/updateTypeSubmit")
    public ServerResponse updateReader(Type type) {
        int i=typeInfoService.updateReader(type);
        if (i>0){
            return ServerResponse.createBySuccess("修改成功");
        }
        return ServerResponse.createByError("修改失败");
    }
    /**
     * 删除类别
     */
    @ResponseBody
    @RequestMapping("/deleteType")
    public ServerResponse deleteType(String ids){
        String arr[]=ids.split(",");
        int i=0;
        for (String id:arr
             ) {
            i+=typeInfoService.deleteType(id);
        }
        if (i>0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByError("删除失败");
    }
}
