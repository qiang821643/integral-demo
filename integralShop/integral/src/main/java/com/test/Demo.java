package com.test;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author: create QiangShW
 * @version: v1.0
 * @description: com.test
 * @date:2019/5/13
 **/
public class Demo {

    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();

        ResponseEntity responseEntity =
         rest.exchange("http://t.weather.sojson.com/api/weather/city/101100101", HttpMethod.GET,null,Object.class);
        int statusCode = responseEntity.getStatusCodeValue();
        Object response =null;
        if(statusCode==200){
         response = responseEntity.getBody();
        }
        System.out.println("天气"+response);
    }

}
