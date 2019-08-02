package com.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】核保及订单确认 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class InsureRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单号-字符-50-Y
	 */
	private String orderId;

	/**
	 * 业务员名称-字符-50-N
	 */
	private String salesmanName;

	/**
	 * 业务员身份证号(深保通功能，深圳必填)-字符-20-N
	 */
	private String salesmanIdNo;

	/**
	 * 业务员密码(深保通功能，深圳必填)-字符-50-Y
	 */
	private String salesmanPassword;

	/**
	 * 车辆联系人名称(深圳公户车车辆联系人信息)-字符-10-N
	 */
	private String linkmanName;

	/**
	 * 车辆联系人身份证号(深圳公户车车辆联系人信息)-字符-20-N
	 */
	private String linkmanIdNo;

	/**
	 * 投保人纳税人识别号或社会信用代码(中煤公户车必填)-字符-N
	 */
	private String holderIdCode;

	/**
	 * 被保人纳税人识别号或社会信用代码(中煤公户车必填)-字符-N
	 */
	private String insuredIdCode;

	/**
	 * 回调地址(异步回调模式必填；地址必须加入平台白名单)-字符-50-CY
	 */
	private String callbackUrl;

	/**
	 * 验证码(太平洋登录验证码)-字符-10-CY
	 */
	private String checkCode;

	/**
	 * 短信校验码(实名认证短信验证码回填)-字符-[4, 10]-CY
	 */
	private String verifyCode;

	/**
	 * 投保人联系电话(核保修改关系人信息)-字符-30-CY
	 */
	private String holderPhone;

}
