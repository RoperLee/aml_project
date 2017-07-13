package com.antimoney.boot.controller;

import com.antimoney.boot.service.impl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 上报记录及上报材料关联关系表
 * Created by Poemafar on 2017/7/11.
 */
@Controller
public class TestController {
    @Autowired
private FileUploadService fileUploadService;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        int i;
        return "success";

    }

}
