package com.zxl.service;


import com.zxl.util.AuthToken;

/**
 * 描述
 *
 * @author zxl
 * @version 1.0
 * @since 1.0
 */
public interface LoginService {
    /**
     * 模拟用户的行为 发送请求 申请令牌 返回
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @param grandType
     * @return
     */
    AuthToken login(String username, String password, String clientId, String clientSecret, String grandType);

    AuthToken loginSms(String phone, String smsCode, String clientId, String clientSecret, String grandType);
}
