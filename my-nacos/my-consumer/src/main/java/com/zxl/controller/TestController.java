package com.zxl.controller;

import com.zxl.client.TestFeignClient;
import com.zxl.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zxl on 2020/12/21.
 */
@RestController
@RequestMapping("/book")
@CrossOrigin
public class TestController {

   @Autowired
   private TestFeignClient testFeignClient;

    @RequestMapping("/getAllInfo")
    public List<Book> getAllInfo(){

        return testFeignClient.getAllInfo();
    }



    @RequestMapping("/findAll")
    public List<Book> findAll(){
        return testFeignClient.findAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Book user){
        return testFeignClient.add(user);
    }

    @RequestMapping("/findById/{id}")
    public Book findById(@PathVariable("id")int id){
        return testFeignClient.findById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Book user){
        return testFeignClient.update(user);
    }

    @DeleteMapping("/del/{id}")
    public String del(@PathVariable("id")int id){
        return testFeignClient.del(id);
    }

    @PostMapping("/addBatch")
    public String addBatch(@RequestBody List<Book> list){
        return testFeignClient.addBatch(list);
    }


    @GetMapping(value="/findPage")
    @PreAuthorize(value="hasAuthority('goods_list')")
    public Object findPage(@RequestParam("pageNum") int pageNum ,@RequestParam("pageSize") int pageSize, Authentication authentication) {
        Object principal = authentication.getPrincipal();
       // springsecurity 获取当前的用户名 传递service

    //    String username = "szitheima";
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String token = details.getTokenValue();
        return testFeignClient.findPage(pageNum,pageSize);
    }
}
