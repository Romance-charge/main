package com.example.bean;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("person")
public class Person {
    //人员ID
    @TableId(type = IdType.AUTO)
    private Long id;

    //用户名
    @Alias("用户名")
    private String name;

    //性别
    @Alias("性别")
    private String gender;

    //年龄
    @Alias("年龄")
    private Integer age;

    //非数据库字段，用于存储其他关联ID列表
    @TableField(exist = false)
    private List<Long> ids;

    //构造函数，接收其他关联ID列表
    public Person(List<Long> ids) {
        this.ids = ids;
    }
}