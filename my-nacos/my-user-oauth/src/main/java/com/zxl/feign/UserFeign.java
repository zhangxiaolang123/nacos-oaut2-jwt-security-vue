package com.zxl.feign;


import com.zxl.entity.Result;
import com.zxl.entity.myUser.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author zxl
 * @version 1.0
 * @since 1.0
 */
@FeignClient(name="my-user")
//@RequestMapping("/user1")
public interface UserFeign {
    @GetMapping("/user/load/{username}")
    public Result<User> findByUsername(@PathVariable(name = "username") String username);
}
