package com.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: create QiangShW
 * @version: v1.0
 * @description: com.mapper
 * @date:2019/5/13
 **/
public interface CityMapper {

    public List<Map<String,Object>> findCityByCityName(@Param("cityName") String cityName);
}
