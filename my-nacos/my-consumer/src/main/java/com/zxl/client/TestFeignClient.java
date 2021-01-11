package com.zxl.client;

import com.zxl.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * zxl
 */
@FeignClient("my-provider")
public interface TestFeignClient {

    @GetMapping("/hi")
    String hi(@RequestParam(value = "name", defaultValue = "forezp", required = false) String name);

    @GetMapping("/getAllInfo")
    List<Book> getAllInfo();

    @GetMapping("/findAll")
    List<Book> findAll();

    @PostMapping(value = "/add")
    String add(@RequestBody Book user);

    @RequestMapping("/findById/{id}")
    Book findById(@PathVariable("id")int id);


    @PutMapping("/update")
    String update(@RequestBody Book user);

    @DeleteMapping("/del/{id}")
    String del(@PathVariable("id")int id);

    @PostMapping("/addBatch")
    String addBatch(@RequestBody List<Book> list);

    @GetMapping(value="/findPage")
    Object findPage(@RequestParam("pageNum") int pageNum ,@RequestParam("pageSize") int pageSize);
}


