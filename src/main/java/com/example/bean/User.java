package com.example.bean;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@TableName("sys_user")
public class User {
    //用户ID
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //用户名
    @Alias("用户名")
    @TableField("username")
    private String username;

    //密码
    @Alias("密码")
    @TableField("password")
    private String password;

    //昵称
    @Alias("昵称")
    @TableField("nickname")
    private String nickname;

    //邮箱
    @Alias("邮箱")
    @TableField("email")
    private String email;

    //电话号码
    @Alias("电话")
    @TableField("phone")
    private String phone;

    //地址
    @Alias("地址")
    @TableField("address")
    private String address;

    //创建时间
    @Alias("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    //非数据库字段，用于存储其他关联ID列表
    @TableField(exist = false)
    private List<Long> ids;

    //构造函数，接收其他关联ID列表
    public User(List<Long> ids) {
        this.ids = ids;
    }

    //获取用户ID
    public Integer getId() {
        return id;
    }

    //设置用户ID
    public void setId(Integer id) {
        this.id = id;
    }

    //获取用户名
    public String getUsername() {
        return username;
    }

    //设置用户名
    public void setUsername(String username) {
        this.username = username;
    }

    //获取密码
    public String getPassword() {
        return password;
    }

    //设置密码
    public void setPassword(String password) {
        this.password = password;
    }

    //获取昵称
    public String getNickname() {
        return nickname;
    }

    //设置昵称
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    //获取邮箱
    public String getEmail() {
        return email;
    }

    //设置邮箱
    public void setEmail(String email) {
        this.email = email;
    }

    //获取电话号码
    public String getPhone() {
        return phone;
    }

    //设置电话号码
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //获取地址
    public String getAddress() {
        return address;
    }

    //设置地址
    public void setAddress(String address) {
        this.address = address;
    }

    //获取创建时间
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    //获取其他关联ID列表
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    //获取其他关联ID列表
    public List<Long> getIds() {
        return ids;
    }

    //设置其他关联ID列表
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}