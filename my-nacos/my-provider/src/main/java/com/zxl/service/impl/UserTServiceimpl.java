package com.zxl.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zxl.entity.Book;
import com.zxl.mapper.BookMapper;
import com.zxl.service.UserService;
import com.zxl.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserTServiceimpl implements UserService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public Book getUserById(int userId) {
        return bookMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int addUser(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int update(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    @Override
    public int del(int id) {
        return bookMapper.deleteByPrimaryKey(id);
    }



    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    @Override
    public PageInfo<Book> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Book> sysMenus = bookMapper.selectPage();
        return new PageInfo<Book>(sysMenus);
    }
}