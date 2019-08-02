package com.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】用户登录 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class LoginRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名-字符-30-Y
	 */
	private String username;

	/**
	 * 密码-字符-50-Y
	 */
	private String password;

	/**
	 * 渠道编码-字符-20-Y
	 */
	private String channelCode;

}