package com.comm;

/**
 * @author Administrator
 *
 */
public interface ApiUrls {

	/**
	 * 登陆 所有API请求,除登录前，需要获取用户授权登录token，并且把token作为http
	 * header为参数认证当前用户信息，在head加入Authorization：登录获取的token.
	 */
	public static final String LOGIN = "http://ybinsure.com/t/icar/std/login";

	/**
	 * 平台属性
	 */
	public static final String QUERY_POLICY_CONFIG = "http://ybinsure.com/t/icar/std/common/queryPolicyConfig";

	/**
	 * 平台险种配置
	 */
	public static final String QUERY_RISK_CONFIG = "http://ybinsure.com/t/icar/std/common/queryRiskConfig";

	/**
	 * 根据客户提供的工号，返回机构网点
	 */
	public static final String QUERY_ORGANIZATION = "http://ybinsure.com/t/icar/std/channel/queryOrganization";

	/**
	 * 根据选择的机构网点，查询可用保险公司
	 */
	public static final String QUERY_COMPANY = "http://ybinsure.com/t/icar/std/channel/queryCompany";

	/**
	 * 根据车牌或车架号查询往年续保数据
	 */
	public static final String QUERY_RENEWAL = "http://ybinsure.com/t/icar/std/queryRenewal";

	/**
	 * 根据品牌型号或车架号查询车辆数据
	 */
	public static final String QUERY_MODEL = "http://ybinsure.com/t/icar/std/vehicle/queryModel";

	/**
	 * 计算车辆实际价格
	 */
	public static final String GET_ACTUAL_PRICE = "http://ybinsure.com/t/icar/std/vehicle/getActualPrice";

	/**
	 * 保费计算 用户输入车辆信息及险别信息,关系人信息等投保信息，调用保费计算接口，获取险别精确保费及相关的平台查询信息
	 */
	public static final String QUOTE = "http://ybinsure.com/t/icar/std/quote";

	/**
	 * 核保及订单确认
	 */
	public static final String INSURE = "http://ybinsure.com/t/icar/std/insure";

	/**
	 * 核保通过后的订单可提交支付申请
	 */
	public static final String PAYMENT = "http://ybinsure.com/t/icar/std/payment";

	/**
	 * 影像上传 若保费计算接口返回images，则需要在核保下单前调用该接口上传影像资料 若核保下单接口返回images，则需要调用该接口上传影像资料后再次调用核保下单接口
	 * 需要调用方有自己的图片服务器，接口只接收图片url地址,必须是可外网访问的地址。
	 */
	public static final String UPLOAD_IMAGE = "http://ybinsure.com/t/icar/std/uploadImage";

	/**
	 * 查询核保状态、保单状态、保单号等信息
	 */
	public static final String QUERY_POLICY_INFO = "http://ybinsure.com/t/icar/std/queryPolicyInfo";

}
