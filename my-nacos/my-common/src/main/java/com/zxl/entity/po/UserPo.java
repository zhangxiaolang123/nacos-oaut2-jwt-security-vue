package com.zxl.entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zxl on 2020/12/30.
 */
@Data
public class UserPo implements Serializable {

    private String username;

    private String password;

    private String smsCode;

    private String phone;


}
