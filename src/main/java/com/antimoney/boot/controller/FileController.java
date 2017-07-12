package com.antimoney.boot.controller;

import com.antimoney.boot.model.FileModel;
import com.antimoney.boot.service.FileUploadServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by wangzhen on 2017/7/9.
 */

@RestController
public class FileController {
    @Autowired
    private FileUploadServiceFacade fileUploadServiceFacade;

    @ResponseBody
    @RequestMapping(value = "/file/postFile")
    public LinkedList<FileModel> upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
       return fileUploadServiceFacade.upload((MultipartHttpServletRequest) request,response);
    }

}

