package com.example.bean;

import lombok.Data;

@Data
public class Monkey {
    //猴子ID
    private Integer id;

    //猴子姓名
    private String name;

    //猴子描述
    private String description;

    //猴子科室
    private String dep;

    //猴子地址
    private String address;

    //电话号码
    private String phone;

    //时间
    private String time;

    //状态
    private String status;
}