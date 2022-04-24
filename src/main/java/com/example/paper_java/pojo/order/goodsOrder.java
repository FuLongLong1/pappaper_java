package com.example.paper_java.pojo.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class goodsOrder {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private int number;
    private String sender;
    private String senderAddress;
    private String senderPhone;
    private String receiver;
    private String receiverAddress;
    private String receiverPhone;
    private String goodsAddress;
    private String remark;
    private String status;
}
