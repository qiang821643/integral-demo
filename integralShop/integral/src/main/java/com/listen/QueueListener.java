package com.listen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mode.DeferredResultHolder;
import com.mode.Order;


/**
 *  监听器
 * @author YangTG
 *
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private Order order;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		new Thread(() ->{
			while (true){
				
				 if(order.getComplateOrder()!=null && !"".equals(order.getComplateOrder())){
					 
					 String number = order.getComplateOrder();
					 deferredResultHolder.getMap().get(number).setResult(number);
					 order.setComplateOrder(null);
					 
				 }else{
					 try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				 }
				
			}
		}).start();
		
		 
		
	}
	
}
