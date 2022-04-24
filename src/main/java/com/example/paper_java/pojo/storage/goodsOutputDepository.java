package com.example.paper_java.pojo.storage;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class goodsOutputDepository {
    private int id;
    private String oId;
    private String name;
    private String address;
    private String date;
    private String uName;
    private String outExamine;
}
