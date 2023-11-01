package com.example.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.bean.Result;
import com.example.bean.User;
import com.example.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private userService service;

    @PostMapping("/add")//新增信息
    public Integer save1(@RequestBody User user) {
        return service.save1(user);
    }

    @GetMapping//查询所有user
    public List<User>     selectAll() {
        return service.selectAll();
    }

    @DeleteMapping("/delete/{param}")//根据id删除user
    public int deleteUser(@PathVariable int param) {
        return service.deleteubyId(param);
    }

    @DeleteMapping("/deleteBatch/{ids}")//批量删除user
    public int deleteUser(@PathVariable Long[] ids) {
        List<Long> longs = Arrays.asList(ids);
        return service.deleteByIds(longs);
    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User store) {
//        String username = store.getUsername();
//        String password = store.getPassword();
//        User user = service.login(username, password);
//        if (user != null) {
//            // 登录成功
//            return ResponseEntity.ok("登录成功");
//        } else {
//            // 登录失败
//            return ResponseEntity.badRequest().body("  登录失败");
//        }
//    } @PostMapping("/login")
//    public int login(@RequestBody User store) {
//        String username = store.getUsername();
//        String password = store.getPassword();
//
//        User user = service.login(username, password);
//        if (user != null) {
//            // 登录成功
//            return 1;
//        } else {
//            // 登录失败
//            return 0;
//        }

//        if (user != null) {
//            // 登录成功
//            return ResponseEntity.ok("登录成功");
//        } else {
//            // 登录失败
//            return ResponseEntity.badRequest().body("  登录失败");
//        }
  //  }

    @PostMapping("/register/")
    public int register(@RequestBody User user) {
        String username = user.getUsername();
        User byUsername = service.findByUsername(username);

        if (byUsername != null) {
            return -1; // 用户名已存在，返回 -1
        } else {
            int res1 = service.register(user.getUsername(), user.getPassword(), user.getAddress(), user.getPhone(), user.getEmail());

            if (res1 == 1) {
                return 1; // 注册成功，返回 1
            } else {
                return 0; // 注册失败，返回 0
            }
        }
    }

    @GetMapping("/search")//根据id查询
    public List<User> searchUsers(@RequestParam("keyword") String keyword, @RequestParam("phone") String phone) {
        return service.searchUsers(keyword, phone);
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<User> list1 = service.selectAll();
        //我们创建Hutool给我们写好的ExcelWrite
        ExcelWriter wirter = ExcelUtil.getWriter(true);
        wirter.write(list1, true);
        //我们将输出的excel文件写出到客户端直接下载
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
//        response.setHeader("Content-Disposition","attachment;filename=test.xls");
        String fileName = URLEncoder.encode("用户相关信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        wirter.flush(out, true);
        //关闭wirter，释放内存
        wirter.close();
        //关机输出servlet流
        IoUtil.close(out);
    }

    @PostMapping("/import")
    public boolean imp(MultipartFile file) throws IOException {
        //获取来自浏览器发送的文件内容
        InputStream inputStream = file.getInputStream();
        //这里我们不用磁盘路径这种写死的，我们使用输入流动态进行读取
//        ExcelReader reader = ExcelUtil.getReader("读取文件来源");
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<User> all = reader.readAll(User.class);
        //我们再使用MP的批量插入插入到数据库中即可

        return true;
    }

//    @GetMapping("/page")
//    public Result selectpage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestParam("keyword") String keyword, @RequestParam("phone") String phone) {
//
//        return service.findByItem(currentPage, pageSize, keyword, phone);
//    }
//@RequestParam("currentPage1")
    @GetMapping("/page1")
    public Result selectpage1( int currentPage, @RequestParam("pageSize1") int pageSize, @RequestParam("keyword") String keyword, @RequestParam("phone") String phone) {
        return service.findByItem1(currentPage, pageSize, keyword, phone);
    }

}