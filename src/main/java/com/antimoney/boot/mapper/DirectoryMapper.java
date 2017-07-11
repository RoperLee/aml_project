package com.antimoney.boot.mapper;

import com.antimoney.boot.model.Directory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roper on 2017/6/9.
 */
@Service
public interface DirectoryMapper {

    List<Directory> getDirectoryListBySubIdAndChapterId(@Param("subjectId") Long subjectId,
                                                        @Param("chapterId") Long chapterId);

    List<Directory> getIssueDirBySubjectIdAndKind(@Param("subjectId") Long subjectId,
                                                  @Param("issueKind") String issueKind);

    Directory getDirectoryById(@Param("id") Long id);

}
