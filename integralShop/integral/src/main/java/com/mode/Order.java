package com.mode;


import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
public class Order {
	
	private String plantOrder;
	
	private String complateOrder;
	
	public void setPlantOrder(String plantOrder){
		new Thread(() ->{
			log.info("接到下单请求"+plantOrder);
			try {
				Thread.sleep(1000);
				this.complateOrder=plantOrder;
				log.info("下单请求出来完毕"+plantOrder);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
	}
}
