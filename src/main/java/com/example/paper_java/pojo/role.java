package com.example.paper_java.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class role {
    private int id;
    private List<String> rightList;
    private String name;
    private String createTime;
    private String authTime;
    private String authName;
}
