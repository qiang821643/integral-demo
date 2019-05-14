package com.mode;

import com.integralenum.ResultCodeEnum;
import lombok.Data;

/**
 * @author: create QiangShW
 * @version: v1.0
 * @description: com.mode
 * @date:2019/5/13
 **/
@Data
public class Result {

    private ResultCodeEnum code;

    private Object data;

    private Object msg;
}
