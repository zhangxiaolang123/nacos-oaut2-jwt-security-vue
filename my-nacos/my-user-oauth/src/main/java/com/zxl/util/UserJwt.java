package com.zxl.util;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class UserJwt implements UserDetails /*extends User*/ {
    private String id;    //用户ID
    private String name;  //用户名字

    private String comny;//设置公司

    private String username;
    private String password;
    private String phone;

    private List<GrantedAuthority> authorities;

    public UserJwt(String username, String password, List<GrantedAuthority> authorities) {
       /* super(username, password, authorities);*/
        this.username = username;
        this.password = password;
        this.authorities = authorities;

    }

    public UserJwt(String username, String password,String phone, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.phone = phone;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
