package com.zym.demo.controller;

import com.zym.demo.dao.UserDao;
import com.zym.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用来测试 docker
 * @author zym
 */
@Api(tags = "测试接口")
@Controller
public class Demo01 {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserDao userDao;

    @ApiOperation(value = "返回index.html")
    @GetMapping("/index")
    public String index() {
        return "/html/index.html";
    }


    @ApiOperation(value = "添加用户")
    @GetMapping("/addUser")
    @ResponseBody
    public String addUser(@ApiParam(name = "用户对象",required = true) User user) {
        int i = userDao.addUser(user);
        return String.valueOf(i);
    }

    @ApiOperation(value = "查询用户")
    @GetMapping("/getUsers")
    @ResponseBody
    public List getUsers() {
        return userDao.getUsers();
    }

    @ApiOperation(value = "添加数据到redis")
    @GetMapping("/setRedis")
    @ResponseBody
    public String setRedis(@Param("key")@ApiParam(name = "key",required = true) String key, @Param("key")@ApiParam(name = "value",required = true) String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }

    @ApiOperation(value = "查询redis中的数据")
    @GetMapping("/getRedis")
    @ResponseBody
    public String getRedis(@Param("key")@ApiParam(name = "key",required = true) String key) {
        System.out.println(key);
        return (String) redisTemplate.opsForValue().get(key);
    }
}
