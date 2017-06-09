package com.computer.boot.model;

import java.util.Date;

/**
 * Created by roper on 2017/6/9.
 */
public class ChapterTopLevel {

    private int id;
    private Date gmtCreat;
    private String isDeleted;
    private String title;
    private Integer parentSubject;
    private Integer sortKeyNumber;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getGmtCreat() { return gmtCreat; }

    public void setGmtCreat(Date gmtCreat) { this.gmtCreat = gmtCreat; }

    public String getIsDeleted() { return isDeleted; }

    public void setIsDeleted(String isDeleted) { this.isDeleted = isDeleted; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Integer getParentSubject() { return parentSubject; }

    public void setParentSubject(Integer parentSubject) { this.parentSubject = parentSubject; }

    public Integer getSortKeyNumber() { return sortKeyNumber; }

    public void setSortKeyNumber(Integer sortKeyNumber) { this.sortKeyNumber = sortKeyNumber; }
}