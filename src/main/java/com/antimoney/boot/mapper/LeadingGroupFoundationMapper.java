package com.antimoney.boot.mapper;

import com.antimoney.boot.model.LeadingGroupFoundation;

public interface LeadingGroupFoundationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_leading_group_foundation
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_leading_group_foundation
     *
     * @mbggenerated
     */
    int insert(LeadingGroupFoundation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_leading_group_foundation
     *
     * @mbggenerated
     */
    int insertSelective(LeadingGroupFoundation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_leading_group_foundation
     *
     * @mbggenerated
     */
    LeadingGroupFoundation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_leading_group_foundation
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LeadingGroupFoundation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aml_leading_group_foundation
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LeadingGroupFoundation record);
}