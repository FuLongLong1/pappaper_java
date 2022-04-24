package com.example.paper_java.pojo.storage;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class packageOutputDepository {
    private int id;
    private String orderId;
    private String name;
    private String address;
    private String date;
    private String userName;
}
