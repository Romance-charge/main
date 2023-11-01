package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HospitalUser {
    //用户ID
    private Integer id;

    //用户名
    private String username;

    //密码
    private String password;

    //姓名
    private String name;

    //科室
    private String dep;

    //办公室
    private String office;

    // 电话号码
    private String phone;

    //用户角色
    private Integer role;
}