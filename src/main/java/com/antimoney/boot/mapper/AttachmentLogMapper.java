package com.antimoney.boot.mapper;

import com.antimoney.boot.model.AttachmentLog;

public interface AttachmentLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_attachment_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_attachment_log
     *
     * @mbggenerated
     */
    int insert(AttachmentLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_attachment_log
     *
     * @mbggenerated
     */
    int insertSelective(AttachmentLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_attachment_log
     *
     * @mbggenerated
     */
    AttachmentLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_attachment_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AttachmentLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_attachment_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AttachmentLog record);
}