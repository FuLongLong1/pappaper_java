package com.example.paper_java.pojo.person;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class staff {
    private int id;
    private String account;
    private String password;
    private String identityCard;
    private String gender;
    private String name;
    private String phoneNumber;
    private String address;
    private int roleId;
}
