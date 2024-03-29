package com.hichengdai.qlqq.front.http;

import java.util.Map;

import com.google.gson.Gson;

public class JsonUtils {

	public static <T> T json2Bean(String json, Class<T> clazz) {
		boolean isJson = new JsonValidator().validate(json);
		if (!isJson) {
			throw new ValidException("830xxx", "json格式不正确");
		}
		T t = null;
		try {
			Gson gson = new Gson();
			t = (T) gson.fromJson(json, clazz);
		} catch (Exception e) {
			throw new ValidException("830xxx", "json2Bean不正确:" + e.getMessage());
		}
		return t;
	}

	public static String object2Json(Object bean) {
		Gson gson = new Gson();
		return gson.toJson(bean);
	}

	public static String string2Json(String key, String value) {
		return "{\"" + key + "\":\"" + value + "\"}";
	}

	/**
	 * 将Map转化为Json
	 * 
	 * @param map
	 * @return String
	 */
	public static <T> String mapToJson(Map<String, T> map) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		return jsonStr;
	}
}
