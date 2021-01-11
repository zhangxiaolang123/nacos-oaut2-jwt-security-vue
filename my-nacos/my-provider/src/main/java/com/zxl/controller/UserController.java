package com.zxl.controller;


import com.zxl.entity.Book;
import com.zxl.service.UserService;
import com.zxl.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxl on 2020/4/4.
 */
@RestController

public class UserController {



    @RequestMapping("/test")
    public String test(){
        System.out.println("123456");
        return "123";
    }

    @RequestMapping("/getAllInfo")
    public List<Book> getAllInfo(){
        System.out.println("123456");
        List<Book>list = new ArrayList<>();
        Book user = new Book();
        user.setId("01");
        user.setAuthor("zhang");
        user.setName("鲁迅先生");
        Book user1 = new Book();
        user1.setId("011");
        user1.setAuthor("xiao");
        user1.setName("鲁迅先生11");
        Book user2 = new Book();
        user2.setId("02");
        user2.setAuthor("lang");
        user2.setName("鲁迅先生2");
        Book user3 = new Book();
        user3.setId("03");
        user3.setAuthor("zhang");
        user3.setName("鲁迅先生3");
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }


    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<Book> findAll(){
        return userService.findAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Book user){
        return userService.addUser(user)==1?"success":"false";
    }

    @RequestMapping("/findById/{id}")
    public Book findById(@PathVariable("id")int id){
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Book user){
        return userService.update(user)==1?"success":"false";
    }

    @DeleteMapping("/del/{id}")
    public String del(@PathVariable("id")int id){
        return userService.del(id)==1?"success":"false";
    }

    @PostMapping("/addBatch")
    public String addBatch(@RequestBody List<Book> list){
        for( Book user : list){
            user.setAuthor(user.getPhone());
            userService.addUser(user);
        }
        return "success";
    }


    @GetMapping(value="/findPage")
    public Object findPage(@RequestParam("pageNum") int pageNum , @RequestParam("pageSize") int pageSize) {
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageNum(pageNum);
        pageQuery.setPageSize(pageSize);
        return userService.getPageInfo(pageQuery);
    }

}
