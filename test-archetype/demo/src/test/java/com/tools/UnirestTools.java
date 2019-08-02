package com.tools;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.comm.Response;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * HTTP 请求工具类
 *
 * @author Administrator
 *
 */
@Slf4j
@Data
@Builder
public class UnirestTools {

	/**
	 * 请求地址
	 */
	private String url;

	/**
	 * 请求参数
	 */
	private Object param;

	/**
	 * 请求头
	 */
	private String header;

	/**
	 * 不加这个注解，Builder模式下会为空
	 */
	@Builder.Default
	private Boolean requestWithJson = false;

	/**
	 * 发起请求
	 */
	@SuppressWarnings("unchecked")
	public <T> Response<T> doPost() {
		Response<T> response = null;
		try {
			String body = this.bulidParam();
			log.info("请求地址:" + url);
			log.info("请求参数:" + body);
			log.info("requestWithJson:" + requestWithJson);
			HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
					.header("content-type",
							requestWithJson ? "application/json"
									: "application/x-www-form-urlencoded")
					.header("Authorization", header).header("cache-control", "no-cache")
					.body(body).asJson();
			Integer responseOk = 200;
			if (jsonResponse.getStatus() == responseOk) {
				String respBody = jsonResponse.getBody().toString();
				response = JSONObject.parseObject(respBody, Response.class);
			}
			else {
				log.error("请求失败:" + JSONObject.toJSONString(jsonResponse));
			}
		}
		catch (Exception e) {
			log.error("请求失败:" + e.getMessage());
		}
		return response;
	}

	/**
	 * 构建form-data格式的请求参数
	 */
	private String bulidParam() {
		StringBuffer sb = new StringBuffer();
		try {
			if (param == null) {
				return sb.toString();
			}
			if (requestWithJson) {
				return JSONObject.toJSONString(param);
			}
			char contract = '&';
			PropertyDescriptor[] props = Introspector
					.getBeanInfo(param.getClass(), Object.class).getPropertyDescriptors();
			if (props != null) {
				for (int i = 0; i < props.length; i++) {
					String name = props[i].getName();
					if ("serialVersionUID".equals(name)) {
						continue;
					}
					String fieldValue = BeanUtils.getProperty(param, name);
					if (fieldValue != null) {
						sb.append(name + "=" + fieldValue + contract);
					}
				}
			}
			int charAtLast = sb.length() - 1;
			if (sb.length() != 0 && contract == sb.charAt(charAtLast)) {
				sb = sb.deleteCharAt(charAtLast);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}