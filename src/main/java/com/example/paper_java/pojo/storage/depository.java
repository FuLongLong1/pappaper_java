package com.example.paper_java.pojo.storage;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class depository {
    private int id;
    private String name;
    private String address;
    private String status;
}
