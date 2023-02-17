package com.uuorb.interview_demo.mapper;

import com.uuorb.interview_demo.entity.CalculateEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
    @Insert("insert into result(input,ratio,result) values(#{number},#{ratio},#{result}) on duplicate key update result=#{result}")
    Integer insertResultToDB(CalculateEntity calculateEntity);
}
