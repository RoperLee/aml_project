package com.antimoney.boot.vo;

import com.antimoney.boot.model.Chapter;
import com.antimoney.boot.model.Directory;

import java.util.List;

/**
 * Created by roper on 2017/6/9.
 */
public class ChapterTreeVo {
    private Chapter chapter;
    private List<Directory> directoryList;

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Directory> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(List<Directory> directoryList) {
        this.directoryList = directoryList;
    }
}
