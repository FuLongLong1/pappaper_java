package com.example.paper_java.pojo.storage;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class goodsInputDepository {
    private int id;
    private String oId;
    private String name;
    private String address;
    private String date;
    private String uName;
    @TableField("put_examine")
    private String putExamine;
}
