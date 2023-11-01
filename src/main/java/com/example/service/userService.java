package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bean.Result;
import com.example.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userService extends IService<User>{

     List<User> searchUsers(String keyword,String phone) ;



//     int selectTotal(String username, String email, String address);


    public int insert(User user);


    public int updateUser(User user);




    public  Integer deleteubyId(@Param("id") Integer id);



  public  List<User> selectAll();

    Integer save1(User user);



    int deleteByIds(List<Long> ids);
//
//    List<User> selectPage(Integer pageNum, Integer pageSize, String username, String email, String address);
//
//    Integer selectTotall(String username, String email, String address);


//    public  List<User> login(String username, String password);


     int register(String username, String password, String address, String phone, String email);

    User login(String username, String password);



//    List<User> getUsers(String username, String email, String address, int pageNum, int pageSize);

//    List<User> login(User user);

//    public int login( User user);

//
//    public Result findByItem(int currentPage, int limit, String username, String phone);

    public Result findByItem1(int currentPag1, int limit1, String username1, String phone1);


    User findByUsername(String username);
    }
