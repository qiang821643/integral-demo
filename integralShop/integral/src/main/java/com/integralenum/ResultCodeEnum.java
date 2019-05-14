package com.integralenum;


import lombok.Getter;

/**
 * @author: create QiangShW
 * @version: v1.0
 * @description: com.integralenum
 * @date:2019/5/13
 **/
@Getter
public enum ResultCodeEnum {

      SUCCESS(0),FIAL(1),EXCEPTION(2);
      private final int code;

      private ResultCodeEnum(int code){
          this.code=code;
      }

}
