package com.uuorb.interview_demo.service;

import com.uuorb.interview_demo.mapper.DemoMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class DemoService {
    @Resource
    DemoMapper demoMapper;
    @Cacheable(cacheNames = "demo",key = "#number+'*'+#ratio")
    public BigDecimal multiple(BigDecimal number, BigDecimal ratio) {
        BigDecimal result = number.multiply(ratio);
        // number由于限定了BigDecimal，所以不需要做防sql注入
        Integer flag = demoMapper.insertResultToDB(number, result);
        // todo: 判断是否插入成功
        return result;
    }
}
