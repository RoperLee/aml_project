package com.antimoney.boot.mapper;

import com.antimoney.boot.model.TransferReport;

public interface TransferReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_transfer_report
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_transfer_report
     *
     * @mbggenerated
     */
    int insert(TransferReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_transfer_report
     *
     * @mbggenerated
     */
    int insertSelective(TransferReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_transfer_report
     *
     * @mbggenerated
     */
    TransferReport selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_transfer_report
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TransferReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_transfer_report
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TransferReport record);
}