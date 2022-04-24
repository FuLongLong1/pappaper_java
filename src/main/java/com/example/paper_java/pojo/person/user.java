package com.example.paper_java.pojo.person;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class user {
    @TableId
    private int id;
    private String account;
    private String password;
    private String userName;
    private String phoneNumber;
    private int roleId;
}
