package com.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.TestMybatis;
import com.service.TestInteface;

@Service
public class TestIntefaceImpl implements TestInteface{
	
	@Autowired
	private TestMybatis mapper;
	
	@Transactional
	@Override
	public Map<String, Object> test() {
		try {
			mapper.updateById();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
			try {
				
				Files.newBufferedReader(Paths.get("d:/qw.txt"));
			} catch (IOException e) {
				throw new RuntimeException();
			}
		
		return null;
	}

}
