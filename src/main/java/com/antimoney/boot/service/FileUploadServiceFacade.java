package com.antimoney.boot.service;

import com.antimoney.boot.model.FileModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by wangzhen on 2017/7/9.
 */
@Service
public interface FileUploadServiceFacade {

    public LinkedList<FileModel> upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException;

}
