package com.zxl.mapper;

import com.zxl.entity.myUser.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:zxl
 * @Description:User的mapper
 * @Date 2019/6/14 0:12
 *****/
public interface UserMapper extends Mapper<User> {
    List<User> selectPage();

    List<User> findAll();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByPhoneOrUsername(@Param("username")String username);
}
