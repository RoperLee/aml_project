package com.antimoney.boot.service;

import com.antimoney.boot.model.User;
import com.antimoney.boot.vo.LastDateVo;
import com.antimoney.boot.vo.RankListVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by roper on 2017/5/15.
 */
@Service
public interface UtilServiceFacade {

    void showPic(HttpServletResponse response, String fileName);

    LastDateVo getExamDate();

    RankListVo getRankList(Long userId, int pageStart, int pageSize);

    boolean addExecuteQuestionCount(Long userId, int count);

    List<String> getBanner();

    User getUserInfo(Long userId);

    Object catchAndSaveImg(MultipartFile[] uploadImg, String extra);

    boolean easyAddQuestion(String postData);
}