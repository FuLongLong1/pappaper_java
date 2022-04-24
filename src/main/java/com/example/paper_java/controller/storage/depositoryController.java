package com.example.paper_java.controller.storage;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.paper_java.dao.storage.depositoryDao;
import com.example.paper_java.pojo.storage.depository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depository")
public class depositoryController {
    @Autowired
    depositoryDao depositorydao;
    //查询数据
    @RequestMapping("/query")
    public List<depository> queryDepository(){
       return depositorydao.selectList(null);
    }
    //添加数据
    @RequestMapping("/add")
    public int addDepository(@RequestBody depository depository){
        return depositorydao.insert(depository);
    }

    //删除数据
    @RequestMapping("/delete")
    public int deleteDepository(@RequestBody List<Integer> list) {
        return depositorydao.deleteBatchIds(list);
    }

    //修改数据
    @RequestMapping("/update")
    public int updateDepository(@RequestBody depository depository) {
        UpdateWrapper<depository> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",depository.getId());
        return depositorydao.update(depository,updateWrapper);
    }
}
