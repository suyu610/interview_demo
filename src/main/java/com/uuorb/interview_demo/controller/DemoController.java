package com.uuorb.interview_demo.controller;

import com.uuorb.interview_demo.entity.vo.Result;
import com.uuorb.interview_demo.constant.Constant;
import com.uuorb.interview_demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class DemoController {
    @Resource
    DemoService demoService;

    @RequestMapping("/multiple")
    Result<Integer> multiple(@RequestParam("number") BigDecimal number, @RequestParam(name = "ratio", required = false) BigDecimal ratio) {
        // validate
        // 如果没有 倍数 参数，则为两倍,这里没做参数校验了
        if (ratio == null) {
            ratio = Constant.DEFAULT_RATIO;
        }

        return Result.ok(demoService.multiple(number,ratio));
    }
}
