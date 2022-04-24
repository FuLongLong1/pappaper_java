package com.example.paper_java.controller.storage;


import com.example.paper_java.pojo.storage.packageInputDepository;
import com.example.paper_java.pojo.storage.packageOutputDepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/packageManage")
public class packageManageController {
    @Autowired
    com.example.paper_java.dao.storage.packageInputDepositoryDao packageInputDepositoryDao;
    @Autowired
    com.example.paper_java.dao.storage.packageOutputDepositoryDao packageOutputDepositoryDao;

    @RequestMapping("/queryInput")
    public List<packageInputDepository> packageInputDepositoryQuery(){
        return packageInputDepositoryDao.selectList(null);
    }

    @RequestMapping("/input")
    public int packageInputDepository(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println(map.get("order"));
        packageInputDepository packageInputDepository=(packageInputDepository) map.get("data");
        packageInputDepository.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return packageInputDepositoryDao.insert(packageInputDepository);
    }

    @RequestMapping("/queryOutput")
    public List<packageOutputDepository> packageOutputDepositoryQuery(){
        return packageOutputDepositoryDao.selectList(null);
    }

    @RequestMapping("/output")
    public int packageOutputDepository(@RequestBody packageOutputDepository packageOutputDepository){
        packageOutputDepository.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return packageOutputDepositoryDao.insert(packageOutputDepository);
    }
}
