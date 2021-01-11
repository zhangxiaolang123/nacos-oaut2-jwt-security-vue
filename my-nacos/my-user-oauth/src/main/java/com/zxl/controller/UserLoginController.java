package com.zxl.controller;


import com.zxl.entity.Result;
import com.zxl.entity.StatusCode;
import com.zxl.entity.po.UserPo;
import com.zxl.service.LoginService;
import com.zxl.util.AuthToken;
import com.zxl.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/*****
 * @Author: zxl
 * @Date: 2020年12月28
 ****/
@RestController
@RequestMapping("/user_auth")
public class UserLoginController {

    @Autowired
    private LoginService loginService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    private static final String GRAND_TYPE = "password";//授权模式 密码模式
    private static final String SMS_GRAND_TYPE = "sms_code";//授权模式 密码模式


    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    //Cookie生命周期
    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;


    //获取token  http://localhost:8001/api/user_auth/login?username=szitheima&password=szitheima   8001是网关
    /**
     * 密码模式  认证.
     *
     * @param username
     * @param password
     * @return
     */
//    @RequestMapping("/login")
//    public Result<Map> login(String username, String password) {
//        //登录 之后生成令牌的数据返回
//        AuthToken authToken = loginService.login(username, password, clientId, clientSecret, GRAND_TYPE);
//        //设置到cookie中
//        saveCookie(authToken.getAccessToken());
//        return new Result<>(true, StatusCode.OK,"令牌生成成功",authToken);
//    }


    //获取token  http://localhost:8001/api/user_auth/login?username=szitheima&password=szitheima   8001是网关
    /**
     * 密码模式  认证.
     *
     * @param userPo
     * @return
     */
    @PostMapping("/login")
    public Result<Map> login(@RequestBody UserPo userPo) {
        //登录 之后生成令牌的数据返回
        AuthToken authToken = loginService.login(userPo.getUsername(), userPo.getPassword(), clientId, clientSecret, GRAND_TYPE);
        //设置到cookie中
        saveCookie(authToken.getAccessToken());
        return new Result<>(true, StatusCode.OK,"令牌生成成功",authToken);
    }

    /**
     * 手机短信登录，验证码（暂不做校验）
     * @param userPo
     * @return
     */
    @PostMapping("/loginSms")
    public Result<Map> loginSms(@RequestBody UserPo userPo) {
        //登录 之后生成令牌的数据返回
        AuthToken authToken = loginService.loginSms(userPo.getPhone(), userPo.getSmsCode(), clientId, clientSecret, SMS_GRAND_TYPE);
        //设置到cookie中
        saveCookie(authToken.getAccessToken());
        return new Result<>(true, StatusCode.OK,"令牌生成成功",authToken);
    }


   /* @PostMapping("/loginT")
    public Result<Map> login() {
        //登录 之后生成令牌的数据返回

        return new Result<>(true, StatusCode.OK,"令牌生成成功","");
    }*/



    private void saveCookie(String token){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        CookieUtil.addCookie(response,cookieDomain,"/","Authorization",token,cookieMaxAge,false);
    }
}
