package com.resp;

import java.io.Serializable;

import lombok.Data;

/**
 * 功能：【悦保车险】用户登录 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class LoginResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 服务令牌-字符
	 */
	private String token;

	/**
	 * 过期时间（单位秒）-字符
	 */
	private String expires;

}