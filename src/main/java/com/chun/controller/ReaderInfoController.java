package com.chun.controller;

import com.chun.pojo.Impl.ReaderInfoVO;
import com.chun.pojo.ReaderInfo;
import com.chun.service.ReaderInfoService;
import com.chun.utils.ServerResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReaderInfoController {

    @Autowired
    ReaderInfoService readerInfoService;

    /**
     * 查询所有读者
     * @param readerInfoVO
     * @return
     */
    @ResponseBody
    @GetMapping("/readerAll")
    public ServerResponse<List<ReaderInfo>> findAllBook(ReaderInfoVO readerInfoVO){
        PageHelper.startPage(readerInfoVO.getPage(),readerInfoVO.getLimit());
        List<ReaderInfo> list = readerInfoService.findAllReader(readerInfoVO);
//        System.out.println(list);
        PageInfo<ReaderInfo> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("查询成功",pageInfo.getList(),pageInfo.getTotal());
    }
    /**
     * 跟新读者
     */
    @ResponseBody
    @RequestMapping(value = "/updateReaderSubmit",method = RequestMethod.POST)
    public ServerResponse updateReader(ReaderInfo readerInfo){
        int i = readerInfoService.updateReader(readerInfo);
        if (i>0){
            return ServerResponse.createBySuccess("修改成功");
        }
        return ServerResponse.createByError("修改失败");
    }
    /**
     * 添加读者
     */
    @ResponseBody
    @RequestMapping("/addReaderSubmit")
    public ServerResponse addReader(ReaderInfo readerInfo){
        System.out.println(readerInfo);
        int i = readerInfoService.addReader(readerInfo);
        System.out.println(i);
        if (i>0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByError("添加失败");
    }
    /**
     * 删除读者
     */
    @ResponseBody
    @RequestMapping("/deleteReader")
    public ServerResponse deleteReader(String ids){
        String arr[]=ids.split(",");
        int i=0;
        for (String id:arr) {
            i+=readerInfoService.deleteReader(id);
        }
        if (i>0){
            return ServerResponse.createBySuccess("删除成功");

        }
        return ServerResponse.createByError("删除失败");
    }
}
