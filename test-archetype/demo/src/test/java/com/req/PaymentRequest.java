package com.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】核保通过后的订单可提交支付申请 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class PaymentRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单号(报价返回的订单号)-字符-50-Y
	 */
	private String orderId;

	/**
	 * 手机号(平安非深圳、四川、内蒙必填； 支付实名认证需要：安徽、山东、海南、河南、江苏、广东、上海、吉林)-字符-20-N
	 */
	private String policyReceiverPhone;

	/**
	 * 回调地址(异步回调模式必填；地址必须加入平台白名单)-字符-50-CY
	 */
	private String callbackUrl;

	/**
	 * 验证码(太平洋登录验证码)-字符-10-CY
	 */
	private String checkCode;

	/**
	 * 验证码(实名认证短信验证码回填)-字符-[4, 10]-N
	 */
	private String verifyCode;

}
