package com.resp;

import java.io.Serializable;

import lombok.Data;

/**
 * 功能：【悦保车险】核保通过后的订单可提交支付申请 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class PaymentResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 支付请求方式(0：支付链接 1：form表单 2：html页面 3：二维码 4：base64(包含data:image/gif;base64,) 5：二维码链接
	 * 9：不在平台支付)-数值
	 */
	private String type;

	/**
	 * 支付请求串（单位秒）-字符
	 */
	private String pay;

	/**
	 * 扩展返回结果（单位秒）-对象
	 */
	private Extend extend;

	/**
	 * 扩展返回结果数据
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Extend implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 校验码(base64图片校验码)-字符
		 */
		private String checkCode;

	}

}
