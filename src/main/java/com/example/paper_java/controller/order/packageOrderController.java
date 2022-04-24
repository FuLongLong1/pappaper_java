package com.example.paper_java.controller.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.paper_java.pojo.order.packageOrder;
import com.example.paper_java.pojo.person.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/packageOrder")
public class packageOrderController {
    @Autowired
    com.example.paper_java.dao.order.packageOrderDao packageOrderDao;
    //根据发件人查询数据
    @RequestMapping("/query")
    public List<packageOrder> queryPackageOrder(@RequestBody user user){
        QueryWrapper<packageOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sender",user.getAccount());
        return packageOrderDao.selectList(queryWrapper);
    }

    @RequestMapping("/add")
    public int addPackageOrder(@RequestBody packageOrder packageOrder){
        packageOrder.setPackageAddress(packageOrder.getSenderAddress());
        packageOrder.setStatus("未入库");
        return packageOrderDao.insert(packageOrder);
    }

    @RequestMapping("/delete")
    public int deletePackageOrder(@RequestBody List<Integer> ids){
        return packageOrderDao.deleteBatchIds(ids);
    }

    @RequestMapping("/update")
    public int updatePackageOrder(@RequestBody packageOrder packageOrder){
        return packageOrderDao.updateById(packageOrder);
    }
    //根据收件人查询数据
    @RequestMapping("/queryPackage")
    public List<packageOrder> queryPackage(@RequestBody user user){
        QueryWrapper<packageOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("receiver",user.getAccount());
        return packageOrderDao.selectList(queryWrapper);
    }

    @RequestMapping("/queryInputStatus")
    public List<packageOrder> queryInputStatus(){
        QueryWrapper<packageOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status","未入库");
        return packageOrderDao.selectList(queryWrapper);
    }

    @RequestMapping("/queryOutputStatus")
    public List<packageOrder> queryOutputStatus(){
        QueryWrapper<packageOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status","已入库");
        return packageOrderDao.selectList(queryWrapper);
    }
    @RequestMapping("/updateInputStatus")
    public int inputDepository(@RequestBody Map<String,Object> map){
        List<Integer> ids=(List<Integer>) map.get("ids");
        List<String> list=(List<String>) map.get("status");
        UpdateWrapper<packageOrder> updateWrapper=new UpdateWrapper<packageOrder>()
                .in("id",ids)
                .set("package_address",list.get(0))
                .set("status",list.get(1));
        return packageOrderDao.update(null,updateWrapper);
    }

    @RequestMapping("/updateOutputStatus")
    public int OutputDepository(@RequestBody List<Integer> ids){
        UpdateWrapper<packageOrder> updateWrapper=new UpdateWrapper<packageOrder>().in("id",ids).set("status","已出库");
        return packageOrderDao.update(null,updateWrapper);
    }
}
