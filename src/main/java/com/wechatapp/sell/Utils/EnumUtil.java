package com.wechatapp.sell.Utils;

import com.wechatapp.sell.Enums.CodeEnum;

public class EnumUtil {


    // <T extends CodeEnum> means this method returns a CodeEnum object
    public static <T extends CodeEnum> T getEnumValueByCode(Integer code, Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if(each.getCode().equals(code))
                return each;
        }
        return null;
    }
}
