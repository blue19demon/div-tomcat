package com.comm;

import java.io.Serializable;

import lombok.Data;

/**
 * 功能：【悦保车险】API响应参数
 *
 * @author Administrator
 * @param <T>
 */
@Data
public class Response<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 流水号-字符-Y
	 */
	private String serialNo;

	/**
	 * 状态码-数值-Y
	 */
	private Integer status;

	/**
	 * 提示信息-字符-Y
	 */
	private String message;

	/**
	 * 返回结果-对象
	 */
	private T data;

	public Boolean isSuccess() {
		return this.status == 200;
	}

}