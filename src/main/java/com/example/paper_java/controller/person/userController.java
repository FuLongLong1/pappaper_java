package com.example.paper_java.controller.person;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.paper_java.dao.person.userDao;
import com.example.paper_java.pojo.person.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userDao userdao;

    //登录
    @RequestMapping("/login")
    public int login(@RequestBody user user){
        QueryWrapper<user> queryWrapper=new QueryWrapper();
        queryWrapper.eq("account",user.getAccount())
                .eq("password",user.getPassword());
        user result=userdao.selectOne(queryWrapper);
        int data=0;
        if(result!=null) data=1;
        return data;
    }
    //查询
    @RequestMapping("/query")
    public List<user> queryUser(){
     List<user> list=userdao.selectList(null);
        System.out.println(list);
        return list;
    }
    //添加
    @RequestMapping("/add")
    public int addUser(@RequestBody user user){
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account",user.getAccount());
        if(null!=userdao.selectOne(queryWrapper)){
            return 0;
        }
        return userdao.insert(user);
    }
    //修改
    @RequestMapping("/update")
    public int updateUser(@RequestBody user user){
        return userdao.updateById(user);
    }
    //删除
    @RequestMapping("/delete")
    public int deleteUser(@RequestBody List<Integer> list){
        return userdao.deleteBatchIds(list);
    }

    @RequestMapping("/queryByAccount")
    public List<user> queryUserByAccount(@RequestBody user user){
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account",user.getAccount());
        return userdao.selectList(queryWrapper);
    }

    @RequestMapping("/queryByCondition")
    public List<user> queryUserByCondition(@RequestBody user user){
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("account",user.getAccount())
                .like("user_name",user.getUserName())
                .like("phone_number",user.getPhoneNumber());
        return userdao.selectList(queryWrapper);
    }
}
