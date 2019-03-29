package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mode.SysUser;

@Mapper
public interface TestMybatis {
	
	public Map<String,Object> demo();
	
	/**
	 * 通过用户名查找当前用户
	 * @return
	 */
	public SysUser findByUserName(@Param(value="userName") String userName);
	
	public void updateById();
	
 }
