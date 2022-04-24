package com.example.paper_java.dao.person;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.paper_java.pojo.person.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userDao extends BaseMapper<user> {
}
