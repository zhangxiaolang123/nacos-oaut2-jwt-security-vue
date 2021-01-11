/*
package com.zxl.controller;


import com.zxl.client.TestFeignClient;
import com.zxl.config.TokenDecode;
import com.zxl.entity.Result;
import com.zxl.entity.StatusCode;
import com.zxl.entity.myCart.OrderItem;
import com.zxl.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

*/
/**
 * 描述
 *
 * @author zxl
 * @version 1.0
 *//*

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;



    @Autowired
    private TokenDecode tokenDecode;

    @Autowired
    private TestFeignClient testFeignClient;

    */
/**
     * 添加购物车
     *
     * @param id  要购买的商品的SKU的ID
     * @param num 要购买的数量
     * @return
     *//*

    @PreAuthorize(value="hasAuthority('goods_list')")
    @RequestMapping("/add")
    public Result add(Long id, Integer num, Authentication authentication) {
     //   Object principal = authentication.getPrincipal();
        //springsecurity 获取当前的用户名 传递service

//        String username = "szitheima";
    //    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
     //   String token = details.getTokenValue();

        Map<String, String> userInfo = tokenDecode.getUserInfo();
        String username = userInfo.get("username");

        System.out.println("哇塞::用户名:"+username);

        cartService.add(id, num, username);
        return new Result(true, StatusCode.OK, "添加成功");

    }

    @RequestMapping("/list")
    public Result<List<OrderItem>> list() {
        Map<String, String> userInfo = tokenDecode.getUserInfo();
        String username = userInfo.get("username");
        System.out.println("哇塞::用户名:"+username);
        List<OrderItem> orderItemList = cartService.list(username);
        return new Result<List<OrderItem>>(true, StatusCode.OK, "列表查询成功", orderItemList);


    }


    @GetMapping(value="/findPage")
    public Object findPage(@RequestParam("pageNum") int pageNum , @RequestParam("pageSize") int pageSize) {
        return testFeignClient.findPage(pageNum,pageSize);
    }


}
*/
