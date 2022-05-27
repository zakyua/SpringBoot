package com.atguigu.springboot.Service.Impl;

import com.atguigu.springboot.Service.UserService;
import com.atguigu.springboot.bean.User;
import com.atguigu.springboot.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author ChenCheng
 * @create 2022-05-26 19:25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {



}
