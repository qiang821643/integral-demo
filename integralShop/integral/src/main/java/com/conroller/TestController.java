package com.conroller;

import java.util.List;
import java.util.Map;

import com.mapper.TestMybatis;
import com.mode.Result;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.TestInteface;


@RestController
@RequestMapping("/testController")
public class TestController {
	
	@Autowired
	private TestInteface test;

	@Autowired
	private CityService cityService;

	@Autowired
	private TestMybatis testMybatis;
	
	@GetMapping("/test")
	public List<Map<String,Object>> test(){
		
		return test.test();
	}

	@GetMapping("/insert")
	public void insert(){
		test.inserCityService();
	}

	@GetMapping("/getWeaterURL")
	public Result getWeatherURL(@RequestParam String cityName){
		System.out.println(cityName);
		return cityService.findCityByCityName(cityName);
	}
}
