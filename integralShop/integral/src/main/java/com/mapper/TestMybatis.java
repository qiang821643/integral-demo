package com.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMybatis {
	
	public Map<String,Object> demo();

	public void insertCity(Map<String,Object> map);
 }
