package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    //用户列表
    private List<User> user;
    //总数
    private Long Total;
//    private int id;
//    private int page; // 当前页码
//    private int pageSize; // 每页显示数量
//    private String username; // 当前页码
//    private int phone; // 每页显示数量
//}
}