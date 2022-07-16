package com.example.traceability_platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("company_id")
    private Integer companyId;    //-1  表示没有公司
    private Integer sex; //1：男 0：女
    private String email;
    private String password;
    @TableField("phone_num")
    private String phoneNum;
    @TableField("private_key")
    private String privateKey; //私钥
    @TableField("public_key")
    private String publicKey;//公钥
}
