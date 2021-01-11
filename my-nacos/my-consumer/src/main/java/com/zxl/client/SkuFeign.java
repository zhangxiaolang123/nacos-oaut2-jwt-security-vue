package com.zxl.client;


import com.zxl.entity.Result;
import com.zxl.entity.myCart.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author zxl
 * @version 1.0
 */
@FeignClient(value="my-provider")
@RequestMapping("/sku")
public interface SkuFeign {
    /**
     * 查询符合条件的状态的SKU的列表
     * @param
     * @return
     */
//    @GetMapping("/status/{status}")
//    public Result<List<Sku>> findByStatus(@PathVariable(name="status") String status);
//
//
//    /**
//     * 根据条件搜索的SKU的列表
//     * @param sku
//     * @return
//     */
//    @PostMapping(value = "/search" )
//    public Result<List<Sku>> findList(@RequestBody(required = false) Sku sku);


    @GetMapping("/{id}")
    public Result<Sku> findById(@PathVariable(name = "id") Long id);



}
