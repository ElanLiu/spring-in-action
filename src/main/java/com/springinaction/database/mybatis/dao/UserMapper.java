package com.springinaction.database.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springinaction.database.DO.User;

public interface UserMapper {
	  @Select("SELECT * FROM user WHERE id = #{userId}")
	  User getUser(@Param("userId") String userId);
	} 
