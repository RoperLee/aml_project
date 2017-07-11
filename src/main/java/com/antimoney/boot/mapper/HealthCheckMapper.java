package com.antimoney.boot.mapper;

import com.antimoney.boot.model.HealthCheck;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Created by roper on 2017/5/15.
 */
@Service
public interface HealthCheckMapper {

    HealthCheck getUserById(@Param("id") int id);

    String getUserNameById(@Param("id") int id);
}
