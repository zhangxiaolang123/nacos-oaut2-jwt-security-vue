package com.zxl.mapper;



import com.zxl.entity.Book;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

/**
 * Created by zxl on 2020/11/29.
 */

public interface BookMapper extends Mapper<Book> {
    List<Book> findAll();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 分页查询用户
     * @return
     */
    List<Book> selectPage();
}
