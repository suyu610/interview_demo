package com.uuorb.interview_demo.controller;

import com.uuorb.interview_demo.entity.CalculateEntity;
import com.uuorb.interview_demo.entity.vo.Result;
import com.uuorb.interview_demo.constant.Constant;
import com.uuorb.interview_demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/multiple")
    Result<Integer> multiple(@RequestParam("number") BigDecimal number, @RequestParam(name = "ratio", required = false) BigDecimal ratio) {
        // validate
        // 如果没有 倍数 参数，则为两倍
        // 这里无须做参数校验
        if (ratio == null) {
            ratio = Constant.DEFAULT_RATIO;
        }
        CalculateEntity calculateEntity = new CalculateEntity.Builder().number(number).ratio(ratio).build();

        return Result.ok(demoService.multiple(calculateEntity));
    }
}
