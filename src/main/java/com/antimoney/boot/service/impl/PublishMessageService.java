package com.antimoney.boot.service.impl;

import com.antimoney.boot.mapper.PublishMessageMapper;
import com.antimoney.boot.model.PublishMessage;
import com.antimoney.boot.service.PublishMessageServiceFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roper on 2017/6/10.
 */
@Service
public class PublishMessageService implements PublishMessageServiceFacade {

    private static final Logger logger = LoggerFactory.getLogger(SubjectDirectoryService.class);

    @Autowired
    private PublishMessageMapper publishMessageMapper;

    @Override
    public List<PublishMessage> getPublishMessage() {
        return publishMessageMapper.getPublishMessage();
    }
}
