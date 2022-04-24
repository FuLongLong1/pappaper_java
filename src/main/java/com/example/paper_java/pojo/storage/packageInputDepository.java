package com.example.paper_java.pojo.storage;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class packageInputDepository {
    @TableId(type = IdType.AUTO)
    private int id;
    private int orderId;
    private String name;
    private String address;
    private String date;
    private String userName;
}
