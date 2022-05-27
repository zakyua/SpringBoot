package com.atguigu.springboot.mapper;


import com.atguigu.springboot.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ChenCheng
 * @create 2022-05-26 19:27
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {
}
