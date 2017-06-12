package com.computer.boot.controller;

import com.computer.boot.service.UtilServiceFacade;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by roper on 2017/6/12.
 */
@RestController
public class UtilController {

    private static final Logger logger = LoggerFactory.getLogger(UtilController.class);

    @Autowired
    private UtilServiceFacade utilServiceFacade;

    /**
     * 获取磁盘图片
     *
     * @param fileName
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/image/showPic")
    public void showPic(@RequestParam("fileName") String fileName,
                        HttpServletRequest request, HttpServletResponse response) {
        utilServiceFacade.showPic(response, fileName);
    }
}