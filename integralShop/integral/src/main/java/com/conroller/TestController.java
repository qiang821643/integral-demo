package com.conroller;

import java.util.Map;

import com.mapper.TestMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TestInteface;


@RestController
@RequestMapping("/testController")
public class TestController {
	
	@Autowired
	private TestInteface test;

	@Autowired
	private TestMybatis testMybatis;
	
	@GetMapping("/test")
	public Map<String,Object> test(){
		
		return test.test();
	}

	@GetMapping("/insert")
	public void insert(){
		test.inserCityService();
	}
}
