package com.req;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】保费计算 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class QuoteRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 基础信息-对象-Y
	 */
	private BaseInfo baseInfo;

	/**
	 * 车辆信息-对象-Y
	 */
	private VehicleInfo vehicleInfo;

	/**
	 * 关系人信息-集合-Y
	 */
	private List<Applicants> applicants;

	/**
	 * 商业险险别信息(投保商业险必传)-集合-CY
	 */
	private List<Kinds> kinds;

	/**
	 * 投保查询校验信息(投保查询校验时必传)-集合-CY
	 */
	private List<Checks> checks;

	/**
	 * 江苏交管车辆校验信息(江苏交管车辆校验时必传)-对象-CY
	 */
	private VehicleCheckInfo vehicleCheckInfo;

	/**
	 * 扩展数据(接口扩展入参，兼容other)-对象-Y
	 */
	private Extend extend;

	/**
	 * 基础信息-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class BaseInfo implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 机构网点编码-字符-32-Y
		 */
		private String organizationId;

		/**
		 * 投保保险公司-字符-10-Y
		 */
		private String companyId;

		/**
		 * 工号编码-字符-N
		 */
		private String channelId;

		/**
		 * 投保类别(0交商共保/1单交强/2单商业)-枚举-10-Y
		 */
		private Integer insuredType;

		/**
		 * 交强险保险起期(格式：YYYY-MM-DD交强险和商业险保险日期至少传一种)-字符-10-N
		 */
		private String tciStartDate;

		/**
		 * 交强险保险止期(格式：YYYY-MM-DD交强险和商业险保险日期至少传一种)-字符-10-N
		 */
		private String tciEndDate;

		/**
		 * 商业险保险起期(格式：YYYY-MM-DD交强险和商业险保险日期至少传一种)-字符-10-N
		 */
		private String vciStartDate;

		/**
		 * 商业险保险止期(格式：YYYY-MM-DD交强险和商业险保险日期至少传一种)-字符-10-N
		 */
		private String vciEndDate;

		/**
		 * 交强险续保到期日(格式：YYYY-MM-DD)-字符-10-N
		 */
		private String tciPolicyEndDate;

		/**
		 * 商业险续保到期日(格式：YYYY-MM-DD)-字符-10-N
		 */
		private String vciPolicyEndDate;

		/**
		 * 订单编号(如果调用该接口有返回，并且需要再次调用该接口时回传)-50-字符-Y
		 */
		private String orderId;

	}

	/**
	 * 车辆信息-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class VehicleInfo implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 车牌号(新车未上牌不填)-字符-32-Y
		 */
		private String licenseNo;

		/**
		 * 品牌型号-字符-50-Y
		 */
		private String brandName;

		/**
		 * 车型编码-字符-20-Y
		 */
		private String modelCode;

		/**
		 * 车架号/vin-字符-17-Y
		 */
		private String frameNo;

		/**
		 * 发动机号-字符-30-Y
		 */
		private String engineNo;

		/**
		 * 初登日期(格式：YYYY-MM-DD)-字符-10-Y
		 */
		private String enrollDate;

		/**
		 * 年款(格式：YYYY-MM-DD)-字符-10-N
		 */
		private String issueYear;

		/**
		 * 新车价格-数值-20-Y
		 */
		private BigDecimal purchasePrice;

		/**
		 * 实际价格-数值-10-N
		 */
		private BigDecimal actualPrice;

		/**
		 * 座位数-数值-10-Y
		 */
		private Integer seatCount;

		/**
		 * 过户日期(格式：YYYY-MM-DD，非过户车不用填)-字符-10-CY
		 */
		private String transferDate;

		/**
		 * 排量/功率(单位：毫升)-数值-10-Y
		 */
		private Float displacement;

		/**
		 * 整备质量(单位：千克)-数值-10-Y
		 */
		private Float curbWeight;

		/**
		 * 核定载质量(单位：吨)-数值-10-Y
		 */
		private Float tonnage;

		/**
		 * 交管车辆类型-枚举-10-Y
		 */
		private String vehicleType;

		/**
		 * 车辆种类-枚举-10-Y
		 */
		private String vehicleCategory;

		/**
		 * 车辆使用性质-枚举-10-Y
		 */
		private String useNature;

		/**
		 * 使用性质细分(当使用性质为营业时必填)-字符-CY
		 */
		private String attachNature;

		/**
		 * 号牌种类-枚举-10-Y
		 */
		private String plateType;

		/**
		 * 号牌底色-枚举-10-Y
		 */
		private String plateColor;

		/**
		 * 能源类型-枚举-10-Y
		 */
		private String energyType;

	}

	/**
	 * 关系人信息-集合
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class Applicants implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 关系人类别(1车主/2被保人/3投保人)-枚举-10-Y
		 */
		private String insuredFlag;

		/**
		 * 关系人名称-字符-100-Y
		 */
		private String name;

		/**
		 * 证件类型-枚举-10-Y
		 */
		private String certificateType;

		/**
		 * 证件号码-字符-30-Y
		 */
		private String certificateNo;

		/**
		 * 联系地址-字符-100-Y
		 */
		private String address;

		/**
		 * 联系电话-字符-30-Y
		 */
		private String phone;

		/**
		 * 关系人出生日期(证件类别为个人，且证件类型不是身份证时必填；格式：YYYY-MM-DD)-字符-10
		 */
		private String birthday;

		/**
		 * 关系人性别(证件类别为个人，且证件类型不是身份证时必填；1 男性 2女性)-枚举-10
		 */
		private String sex;

		/**
		 * 邮箱(电子保单接收邮箱)-字符-30
		 */
		private String email;

	}

	/**
	 * 商业险险别信息(投保商业险必传)-集合
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class Kinds implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 险别代码(投保商业险必填)-枚举-10-Y
		 */
		private String riskCode;

		/**
		 * 保额-枚举?-10
		 */
		private BigDecimal amount;

		/**
		 * 座位数(司机险填1/乘客险填座位数-1)-数值-4
		 */
		private Integer quantity;

		/**
		 * 每座保险金额-枚举?-10
		 */
		private String unitAmount;

		/**
		 * 玻璃类型(玻璃险必填；0国产/1进口)-枚举-10
		 */
		private String glassType;

		/**
		 * 是否投保不计免赔(0否/1是)-枚举-2-Y
		 */
		private String isDeductible;

	}

	/**
	 * 投保查询校验信息(投保查询校验时必传)-集合
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class Checks implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 校验类型标志(0非转保业务/1转保业务；如果有返回，需要回传)-枚举-2
		 */
		private String renewalFlag;

		/**
		 * 校验类别(0交强险转保车验证码/1商业险转保车验证码)-枚举-2
		 */
		private String checkFlag;

		/**
		 * 查询码(投保查询校验时不能为空)-字符-50
		 */
		private String checkNo;

		/**
		 * 验证码(投保查询校验时不能为空)-字符-10
		 */
		private String checkCode;

	}

	/**
	 * 江苏交管车辆校验信息(江苏交管车辆校验时必传)-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class VehicleCheckInfo implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 查询码(投保查询校验时不能为空)-字符-50
		 */
		private String checkNo;

		/**
		 * 验证码(投保查询校验时不能为空)-字符-10
		 */
		private String checkCode;

	}

	/**
	 * 扩展数据(接口扩展入参，兼容other)-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class Extend implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 车辆联系人名称(深圳人保公户车必填)-字符-10
		 */
		private String linkmanName;

		/**
		 * 车辆联系人身份证号(深圳人保公户车必填)-字符-20-Y
		 */
		private String linkmanIdNo;

		/**
		 * 投保人固定电话(诚泰公户车必填太平洋支持填写格式：区号-号码-分机号，如果没有分机号，号码后面部分不填写)-字符-20-Y
		 */
		private String holderTelephone;

		/**
		 * 回调地址(异步回调模式必填；地址必须加入平台白名单)-字符-50-CY
		 */
		private String callbackUrl;

		/**
		 * 校验码(需要前端录入的校验码)-字符-10
		 */
		private String checkCode;

	}

}
