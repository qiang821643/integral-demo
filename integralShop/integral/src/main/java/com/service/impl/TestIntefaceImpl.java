package com.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.util.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import com.mapper.TestMybatis;
import com.service.TestInteface;

@Service
public class TestIntefaceImpl implements TestInteface{
	
	@Autowired
	private TestMybatis mapper;
	@Autowired
	private ReadFile readFile;

	@Override
	public Map<String, Object> test() {
		
		System.out.println(mapper.demo());
		return mapper.demo();
	}

	@Override
	public void inserCityService() {
		String str = readFile.readFile("C:/Users/YangTG/Desktop/_city.txt");
		List<Object> list = JSON.parseArray(str);

		list.forEach(a->{
			Map<String,Object> map = new HashMap<>();
			map.put("id",JSONObject.parseObject(a.toString()).get("id"));
			map.put("pid",JSONObject.parseObject(a.toString()).get("pid"));
			map.put("city_code",JSONObject.parseObject(a.toString()).get("city_code"));
			map.put("city_name",JSONObject.parseObject(a.toString()).get("city_name"));
			mapper.insertCity(map);
		});

	}


}
