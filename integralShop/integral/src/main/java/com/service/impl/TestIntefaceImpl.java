package com.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.TestMybatis;
import com.service.TestInteface;

@Service
public class TestIntefaceImpl implements TestInteface{
	
	@Autowired
	private TestMybatis mapper;

	@Override
	public Map<String, Object> test() {
		
		System.out.println(mapper.demo());
		return mapper.demo();
	}

}
