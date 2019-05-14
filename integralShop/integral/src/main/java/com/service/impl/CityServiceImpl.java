package com.service.impl;

import com.constant.Constant;
import com.integralenum.ResultCodeEnum;
import com.mapper.CityMapper;
import com.mode.Result;
import com.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create QiangShW
 * @version: v1.0
 * @description: com.service.impl
 * @date:2019/5/13
 **/
@Service
@Slf4j
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Result findCityByCityName(String cityName) {
        log.info("地名",cityName);
        List<Map<String,Object>> cityList = cityMapper.findCityByCityName(cityName);
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();
        if(cityList!=null && !cityList.isEmpty()){
            String code = String.valueOf(cityList.get(0).get("city_code"));
            result.setCode(ResultCodeEnum.SUCCESS);
            if(!StringUtils.isBlank(code)){
                map.put("url", Constant.URL +code);
                result.setData(map);
                return result;
            }else {
                result.setMsg("省无法查询天气连接");
                return result;
            }

        }else{
            result.setCode(ResultCodeEnum.FIAL);
            result.setMsg("没有这个市/县");
            return result;
        }
    }
}
