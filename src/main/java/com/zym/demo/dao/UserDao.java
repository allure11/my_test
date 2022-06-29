package com.zym.demo.dao;

import com.zym.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Insert("insert into users(name, age) values(#{name}, #{age})")
    int addUser(User user);

    @Select("select * from users")
    List<User> getUsers();
}
