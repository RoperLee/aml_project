package com.antimoney.boot.mapper;

import com.antimoney.boot.model.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roper on 2017/6/9.
 */
@Service
public interface QuestionMapper {

    List<Question> getQuestionListBySubDirAndType(@Param("subjectId") Long subjectId,
                                                  @Param("directoryId") Long directoryId,
                                                  @Param("questionType") String questionType);

    Long selectTotalNumber(@Param("subjectId") Long subjectId,
                           @Param("directoryId") Long directoryId);

    List<Question> queryQuestionListByKeyWord(@Param("pageStart") int pageStart,
                                              @Param("pageSize") int pageSize,
                                              @Param("keyWord") String keyWord,
                                              @Param("subjectId") int subjectId);

    Long queryTotalNumber(@Param("keyWord") String keyWord,
                          @Param("subjectId") int subjectId);

    Question getQuestionById(@Param("id") Long id);

    void insertQuestionData(Question question);

    Long hasExistCurrentQuestion(@Param("subjectId") Long subjectId,
                                 @Param("directoryId") Long directoryId,
                                 @Param("sortKeyNumber") Long sortKeyNumber);

    void deleteCurrentQuestion(@Param("subjectId") Long subjectId,
                               @Param("directoryId") Long directoryId,
                               @Param("sortKeyNumber") Long sortKeyNumber);

}
