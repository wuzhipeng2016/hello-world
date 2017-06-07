package com.mark.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WebUtil {
	public static Map<String, String> parseRequestData(HttpServletRequest request)
	{
		Map<String,String[]> mapRequest = request.getParameterMap();
		Map<String,String> map = new HashMap<String,String>();
		int i = mapRequest.size();
		for (Entry<String,String[]> entry : mapRequest.entrySet()) {
			map.put((entry.getKey()).toUpperCase(), ((String[])entry.getValue())[0]);
		}
		return map;
	}
//	Map -> Json
//	Json json1 = (new Gson()).toJson(map);
	
//	Json -> Map
//	Map<String,String> map1= (new Gson()).fromJson(json, new TypeToken<Map<String, String>>(){}.getType());
//	如果是复杂Json，则需要处理Json数组等问题
}
