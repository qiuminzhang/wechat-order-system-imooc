package com.wechatapp.sell.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** A util class used to convert a string to json format. */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
