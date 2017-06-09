package com.computer.boot.mapper;

import com.computer.boot.model.ChapterLastLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roper on 2017/6/9.
 */
@Service
public interface ChapterLastLevelMapper {

    List<ChapterLastLevel> getLastChapterListByParentId(@Param("parentId") int parentId);

}