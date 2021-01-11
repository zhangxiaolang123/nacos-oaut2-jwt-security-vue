package com.zxl.service;


import com.zxl.util.AuthToken;

/*****
 * @Author: zxl
 ****/
public interface AuthService {

    /***
     * 授权认证方法
     */
    AuthToken login(String username, String password, String clientId, String clientSecret);
}
