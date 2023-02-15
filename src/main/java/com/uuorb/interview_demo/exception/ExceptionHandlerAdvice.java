package com.uuorb.interview_demo.exception;

import com.uuorb.interview_demo.entity.vo.Result;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionHandlerAdvice {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result entityTransExceptionHandle(HttpServletRequest request, MissingServletRequestParameterException e) {
        Result result = Result.paramValidError("参数 " + e.getParameterName() + " 缺失");
        return result;
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result methodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException e) {
        // todo: 日志
        System.out.println(e);
        e.fillInStackTrace();
        Result result = Result.paramValidError("参数 " + e.getName() + " 类型错误，所须类型为："+e.getRequiredType());
        return result;
    }
}
