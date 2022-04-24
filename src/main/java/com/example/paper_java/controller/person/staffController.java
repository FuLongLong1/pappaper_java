package com.example.paper_java.controller.person;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.paper_java.dao.person.staffDao;
import com.example.paper_java.pojo.person.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class staffController {
    @Autowired
    staffDao staffDao;

    //管理员登录
    @RequestMapping("/login")
    public int login(@RequestBody staff staff){
        QueryWrapper<staff> queryWrapper=new QueryWrapper();
        queryWrapper.eq("account",staff.getAccount())
                .eq("password",staff.getPassword());
        staff data=staffDao.selectOne(queryWrapper);
        if (data == null) return 2;
        return 1;
    }

    //查询数据
    @RequestMapping("/query")
    public List<staff> queryStaff() {
        return staffDao.selectList(null);
    }
    //添加数据
    @RequestMapping("/add")
    public int addStaff(@RequestBody staff staff) {
        return staffDao.insert(staff);
    }
    //删除数据
    @RequestMapping("/delete")
    public int deleteStaff(@RequestBody List<Integer> list) {
        return staffDao.deleteBatchIds(list);
    }
    //修改数据
    @RequestMapping("/update")
    public int updateStaff(@RequestBody staff staff) {
        UpdateWrapper<staff> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",staff.getId());
        return staffDao.update(staff,updateWrapper);
    }
}
