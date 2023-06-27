package com.chun.controller;

import com.chun.pojo.Analysis;
import com.chun.service.AnalysisService;
import com.chun.service.impl.AnalysisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

//    /**
//     * 每种类别书的数量
//     */
//    @RequestMapping("analysis")
//    public String analysis(Model model){
//
//        List<Analysis> list =analysisService.typeBook();
//        model.addAttribute("list",list);
//        return "analysis";
//    }
}
