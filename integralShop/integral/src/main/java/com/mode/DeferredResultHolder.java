package com.mode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import lombok.Data;

@Data
@Component
public class DeferredResultHolder {
	
	
	private Map<String,DeferredResult> map = new HashMap<>();
	
	
}
