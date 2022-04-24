package com.example.paper_java.controller.storage;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.paper_java.dao.storage.goodsInputDepositoryDao;
import com.example.paper_java.dao.storage.goodsOutputDepositoryDao;
import com.example.paper_java.pojo.storage.goodsInputDepository;
import com.example.paper_java.pojo.storage.goodsOutputDepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goodsManage")
public class goodsManageController {
    @Autowired
    goodsInputDepositoryDao goodsInputDepositoryDao;
    @Autowired
    goodsOutputDepositoryDao goodsOutputDepositoryDao;

    @RequestMapping("/queryInput")
    public List<goodsInputDepository> goodsInputDepositoryQuery(){
        return goodsInputDepositoryDao.selectList(null);
    }

    @RequestMapping("/input")
    public int goodsInputDepository(@RequestBody goodsInputDepository goodsInputDepository){
        System.out.println(goodsInputDepository);
        goodsInputDepository.setOId("3");
        goodsInputDepository.setUName("tom");
        goodsInputDepository.setPutExamine("未审核");
        return goodsInputDepositoryDao.insert(goodsInputDepository);
    }

    @RequestMapping("/queryOutput")
    public List<goodsOutputDepository> goodsOutputDepositoryQuery(){
        return goodsOutputDepositoryDao.selectList(null);
    }

    @RequestMapping("/output")
    public int goodsOutputDepository(@RequestBody goodsOutputDepository goodsOutputDepository){
        System.out.println(goodsOutputDepository);
        goodsOutputDepository.setOId("3");
        goodsOutputDepository.setUName("tom");
        goodsOutputDepository.setOutExamine("未审核");
        return goodsOutputDepositoryDao.insert(goodsOutputDepository);
    }

    //审批,接收一个数组，最后一个值为审核字段的值
    @RequestMapping("examineInput")
    public int examineInput(@RequestBody List<Integer> list) {
        int value=list.get(list.size()-1);
        String examine;
        if(value==1){
            examine="审核";
        }else if(value==2){
            examine="审批";
        }else {
            examine="退回";
        }
        list.remove(list.size()-1);
        UpdateWrapper<goodsInputDepository> updateWrapper=new UpdateWrapper<>();
        updateWrapper.in("id",list)
                .set("put_examine",examine);
        int result=goodsInputDepositoryDao.update(null,updateWrapper);
        return result;
    }

    @RequestMapping("examineOutput")
    public int examineOutput(@RequestBody List<Integer> list) {
        int value=list.get(list.size()-1);
        String examine;
        if(value==1){
            examine="审核";
        }else if(value==2){
            examine="未审核";
        }else {
            examine="退回";
        }
        list.remove(list.size()-1);
        UpdateWrapper<goodsOutputDepository> updateWrapper=new UpdateWrapper<>();
        updateWrapper.in("id",list)
                .set("out_examine",examine);
        int result=goodsOutputDepositoryDao.update(null,updateWrapper);
        return result;
    }

}
