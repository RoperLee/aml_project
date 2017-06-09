package com.computer.boot.mapper;

import com.computer.boot.model.ChapterTopLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by roper on 2017/6/9.
 */
public interface ChapterTopLevelMapper {

    List<ChapterTopLevel> getTopChapterListBySubjectId(@Param("parentId") int parentId);

}
