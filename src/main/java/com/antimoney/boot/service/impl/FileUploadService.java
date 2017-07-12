package com.antimoney.boot.service.impl;

import com.antimoney.boot.common.Constants;
import com.antimoney.boot.model.FileModel;
import com.antimoney.boot.service.FileUploadServiceFacade;
import com.antimoney.boot.utils.XLSXUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by wangzhen on 2017/7/9.
 */
@Service
public class FileUploadService implements FileUploadServiceFacade {

    @Override
    public LinkedList<FileModel> upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
        LinkedList<FileModel> files = new LinkedList<FileModel>();
        FileModel fileModel = null;

        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;

        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            fileModel = new FileModel();
            fileModel.setFileName(mpf.getOriginalFilename());
            fileModel.setSize(mpf.getSize());
            String fileType = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf(".") + 1);
            fileModel.setFileType(fileType);
            String aimDir = Constants.FILE_PATH_BASE + fileModel.getFileType() + "/" + mpf.getOriginalFilename();
            fileModel.setFilePath(aimDir);
            File file = new File(aimDir);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(aimDir));

            if (fileType.equalsIgnoreCase("xlsx")) {
                fileModel.setXlsModel(new XLSXUtil().getFromPath(fileModel.getFilePath()));
            }

            files.add(fileModel);
        }

        return files;
    }


}
