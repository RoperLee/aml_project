package com.antimoney.boot.mapper;

import com.antimoney.boot.model.PublishMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roper on 2017/6/10.
 */
@Service
public interface PublishMessageMapper {

    List<PublishMessage> getPublishMessage();

}
