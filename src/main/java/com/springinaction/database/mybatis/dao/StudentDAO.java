package com.springinaction.database.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springinaction.database.DO.Student;

public interface StudentDAO {
	@Select("SELECT * FROM student WHERE id = #{SNO}")
	Student getStudentByNo(@Param("SNO") String SNO);
}
