package com.example.paper_java.controller;

import com.example.paper_java.dao.roleDao;
import com.example.paper_java.pojo.role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.apache.tomcat.util.http.FastHttpDateFormat.getCurrentDate;

@RestController
@RequestMapping("/role")
public class roleController {
    @Autowired
    roleDao roleDao;

    @RequestMapping("query")
    public List<role> roleQuery(){
        return roleDao.selectList(null);
    }

    @RequestMapping("add")
    public int roleQuery(@RequestBody role role){
        role.setCreateTime(getCurrentDate());
        System.out.println(role);
        return roleDao.insert(role);
    }
}
