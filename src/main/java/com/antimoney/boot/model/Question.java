package com.antimoney.boot.model;

/**
 * Created by roper on 2017/6/9.
 */
public class Question extends BasicModelObject {

    private String questionType;
    private String content;
    private String option;
    private String analysis;
    private int subjectId;
    private String kind;
    private Long directoryId;
    private Long sortKeyNumber;
    private String extraInfo;

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Long directoryId) {
        this.directoryId = directoryId;
    }

    public Long getSortKeyNumber() {
        return sortKeyNumber;
    }

    public void setSortKeyNumber(Long sortKeyNumber) {
        this.sortKeyNumber = sortKeyNumber;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
