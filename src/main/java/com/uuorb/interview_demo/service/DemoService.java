package com.uuorb.interview_demo.service;

import com.uuorb.interview_demo.entity.CalculateEntity;
import com.uuorb.interview_demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class DemoService {
    @Autowired
    DemoMapper demoMapper;

    @Cacheable(cacheNames = "demo", key = "#c.number+'*'+#c.ratio")
    public BigDecimal multiple(CalculateEntity c) {
        BigDecimal result = c.getNumber().multiply(c.getRatio());
        c.setResult(result);
        // number由于限定了BigDecimal，所以不需要做防sql注入
        Integer flag = demoMapper.insertResultToDB(c);
        // todo: 判断是否插入成功
        return result;
    }
}
