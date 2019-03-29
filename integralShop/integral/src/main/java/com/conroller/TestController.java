package com.conroller;

import java.util.Map;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.ArrayBlockingQueue;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
//import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import com.mode.DeferredResultHolder;
import com.mode.Order;
import com.service.TestInteface;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/testController")
@Slf4j
public class TestController {
	
	@Autowired
	private TestInteface test;
	
	@Autowired
	private Order order;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	
	@GetMapping("/test")
	public void test(){
		 test.test();
	}
	
	@GetMapping("/getOrder")
	public DeferredResult<String> getOrder(){
		log.info("主线程开始");
			log.info("子线程开始");
			String number = "12345678";
			order.setPlantOrder(number);
			DeferredResult<String> result = new DeferredResult<>();
			deferredResultHolder.getMap().put(number, result);
			log.info("子线程结束");
		log.info("主线程结束");
		
		return result;
	}
}
