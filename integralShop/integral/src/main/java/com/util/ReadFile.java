package com.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.mode.City;
import static com.alibaba.fastjson.JSON.parseArray;


/**
 * @author: create QiangShW
 * @version: v1.0
 * @description: com.util
 * @date:2019/5/13
 **/
@Component

public class ReadFile {

    public  String readFile(String url){

        String str="";
        try {
            File file = new File(url);

            str = FileUtils.readFileToString(file,"utf-8");

        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    /*public static void main(String[] args) {
      String str =  ReadFile.readFile("C:/Users/YangTG/Desktop/_city.txt");
      List<Object> list = JSON.parseArray(str);
      list.forEach(a->{
         Object str1 =  JSONObject.parseObject(a.toString()).get("city_name");
          System.out.println(str1);
      });
    }*/
}
