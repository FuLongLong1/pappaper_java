package com.example.paper_java.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.paper_java.pojo.role;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface roleDao extends BaseMapper<role> {
}
