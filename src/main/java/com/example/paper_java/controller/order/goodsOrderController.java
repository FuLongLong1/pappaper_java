package com.example.paper_java.controller.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.paper_java.pojo.order.goodsOrder;
import com.example.paper_java.pojo.person.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goodsOrder")
public class goodsOrderController {
    @Autowired
    com.example.paper_java.dao.order.goodsOrderDao goodsOrderDao;

    @RequestMapping("/query")
    public List<goodsOrder> queryGoodsOrder(@RequestBody user user){
        QueryWrapper<goodsOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sender",user.getAccount());
        return goodsOrderDao.selectList(queryWrapper);
    }

    @RequestMapping("/add")
    public int addGoodsOrder(@RequestBody goodsOrder goodsOrder){
        goodsOrder.setGoodsAddress(goodsOrder.getSenderAddress());
        goodsOrder.setStatus("未入库");
        return goodsOrderDao.insert(goodsOrder);
    }

    @RequestMapping("/delete")
    public int deleteGoodsOrder(@RequestBody List<Integer> ids){
        return goodsOrderDao.deleteBatchIds(ids);
    }

    @RequestMapping("/update")
    public int updateGoodsOrder(@RequestBody goodsOrder goodsOrder){
        return goodsOrderDao.updateById(goodsOrder);
    }

    @RequestMapping("/queryGoods")
    public List<goodsOrder> queryGoods(@RequestBody user user){
        QueryWrapper<goodsOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("receiver",user.getAccount());
        return goodsOrderDao.selectList(queryWrapper);
    }
}
