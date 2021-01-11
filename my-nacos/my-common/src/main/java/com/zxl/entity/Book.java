package com.zxl.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable{

    private String id;

    private String userName;

    private String password;

    private Integer age;

    private String author;

    private String name;

    private String phone;


}