package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    public List<User> selectAll();

    public int insert(User user);



    public int updateUser(User user);


    public  Integer deleteubyId(@Param("id") Integer id);
//    List<User> selectPage(@Param("username") String username,
//                          @Param("email") String email,
//                          @Param("address") String address,
//                          @Param("offset") int offset,
//                          @Param("pageSize") int pageSize);
//
//
//    Integer selectTotal(@Param("username") String username,
//                        @Param("email") String email,
//                        @Param("address") String address);

//
//    //分页fenye
//    List<User> selectPage(@Param("pageNum")Integer pageNum, @Param("pageSize") Integer pageSize,@Param("username") String username,@Param("email") String email,@Param("address") String address);
//    Integer selectTotall(@Param("username") String username,@Param("email") String email,@Param("address") String address);
//

    int deleteByIds(@Param("ids") List<Long> ids);


//    public Page<User> findByPage(int pageCode, int pageSize);


//    User selectByUsername(User user);
//
//    User selectByUserNameAndPassword(User user);
//
//    int insertUser(User user);

//    List<User> login( @Param("username")String username,@Param("password") String password);
//public List<User> login( User user);
//public List<User> login( User user);

//    @Select("SELECT id, username, password, nickname, email, phone, address, create_time " +
//            "FROM sys_user " +
//            "WHERE username=#{username} AND password=#{password}")

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);




    int register(@Param("username")String username, @Param("password")String password, @Param("address")String address,@Param("phone") String phone,@Param("email") String email);

    List<User> searchUsers(String keyword,String phone);

    List<User> getUsersByPage(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("username") String username,@Param("phone") String phone);

    @Select("SELECT COUNT(*) FROM  sys_user")
    Long countAll();

    User findByUsername(String username);
}

