package com.uuorb.interview_demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface DemoMapper {
    @Insert("insert into result(input,ratio,result) values(#{input},#{ratio},#{result}) on duplicate key update result=#{result}")
    Integer insertResultToDB(BigDecimal input, BigDecimal ratio, BigDecimal result);
}
