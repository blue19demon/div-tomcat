package com.resp;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * 功能：【悦保车险】根据车牌或车架号查询往年续保数据 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QueryRenewalResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 保单信息-对象
	 */
	private Policy policy;

	/**
	 * 车辆信息-对象
	 */
	private Vehicle vehicle;

	/**
	 * 关系人信息-对象
	 */
	private Applicant applicant;

	/**
	 * 险种信息-对象
	 */
	private Risks risks;

	/**
	 * 保单信息-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Policy implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 保险公司id-数值
		 */
		private Integer companyId;

		/**
		 * 保险公司名称-字符
		 */
		private String companyName;

		/**
		 * 交强险起保日期(YYYY-MM-DD)-字符
		 */
		private String tciStartDate;

		/**
		 * 交强险终保日期(YYYY-MM-DD)-字符
		 */
		private String tciEndDate;

		/**
		 * 商业险起保日期(YYYY-MM-DD)-字符
		 */
		private String vciStartDate;

		/**
		 * 商业险终保日期(YYYY-MM-DD)-字符
		 */
		private String vciEndDate;

		/**
		 * 总保费-数值
		 */
		private BigDecimal totalPremium;

		/**
		 * 交强险保费-数值
		 */
		private BigDecimal tciPremium;

		/**
		 * 商业险保费-数值
		 */
		private BigDecimal vciPremium;

		/**
		 * 车船税-数值
		 */
		private BigDecimal vehicleTax;

		/**
		 * 交强险出险次数-数值 允许负值；负值代表连续几年未出险； 正值代表上年出险几次； 0代表新车；空代表没查到
		 */
		private Integer tciLossOccurredCount;

		/**
		 * 商业险出险次数-数值
		 */
		private Integer vciLossOccurredCount;

		/**
		 * 交强险折扣-数值
		 */
		private BigDecimal tciDiscount;

		/**
		 * 商业险折扣-数值
		 */
		private BigDecimal vciDiscount;

		/**
		 * 投保单号(核保完成返回)-字符
		 */
		private String proposalNo;

		/**
		 * 交强险投保单号(核保完成返回)-字符
		 */
		private String tciProposalNo;

		/**
		 * 商业险投保单号(核保完成返回)-字符
		 */
		private String vciProposalNo;

		/**
		 * 交强险保单号(核保完成返回)-字符
		 */
		private String tciPolicyNo;

		/**
		 * 商业险保单号(核保完成返回)-字符
		 */
		private String vciPolicyNo;

		/**
		 * 交强险核保状态(核保完成返回)-数值 核保状态 状态说明 0 待审核 1 审核通过 2 下发修改/拒保
		 */
		private String tciPolicyStatus;

		/**
		 * 交强险保单状态描述(核保完成返回)-字符
		 */
		private String tciStatusMessage;

		/**
		 * 商业险核保状态(核保完成返回)-数值
		 */
		private String vciPolicyStatus;

		/**
		 * 商业险保单状态描述(核保完成返回)-字符
		 */
		private String vciStatusMessage;

		/**
		 * 保单状态-数值 保单状态 状态说明 0 报价失败 1 报价成功 2 下发修改 3 人工审核 4 核保成功 5 支付失败 6 支付成功 7 承保失败 8
		 * 承保成功
		 */
		private String policyStatus;

		/**
		 * 报价失败原因/核保失败原因-字符
		 */
		private String reason;

	}

	/**
	 * 车辆信息-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Vehicle implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 车牌号-字符
		 */
		private String licenseNo;

		/**
		 * 品牌型号-字符
		 */
		private String brandName;

		/**
		 * 精友车型编码-字符
		 */
		private String jyModelCode;

		/**
		 * 车型编码-字符
		 */
		private String modelCode;

		/**
		 * 车架号/vin-字符
		 */
		private String frameNo;

		/**
		 * 发动机号-字符
		 */
		private String engineNo;

		/**
		 * 初登日期(YYYY-MM-DD)-字符
		 */
		private String enrollDate;

		/**
		 * 年款-字符
		 */
		private String issueYear;

		/**
		 * 新车价格-数值
		 */
		private BigDecimal purchasePrice;

		/**
		 * 实际价格-数值
		 */
		private BigDecimal actualPrice;

		/**
		 * 座位数-数值
		 */
		private Integer seatCount;

		/**
		 * 过户日期(YYYY-MM-DD)-字符
		 */
		private String transferDate;

		/**
		 * 排量/功率-数值
		 */
		private Float displacement;

		/**
		 * 整备质量-数值
		 */
		private Float curbWeight;

		/**
		 * 核定载质量-数值
		 */
		private Float tonnage;

		/**
		 * 交管车辆类型-字符
		 */
		private String vehicleType;

		/**
		 * 车辆种类-字符
		 */
		private String vehicleCategory;

		/**
		 * 车辆使用性质-字符
		 */
		private String useNature;

		/**
		 * 使用性质细分-字符
		 */
		private String attachNature;

		/**
		 * 号牌种类-字符
		 */
		private String plateType;

		/**
		 * 号牌底色-字符
		 */
		private String plateColor;

		/**
		 * 能源类型-字符
		 */
		private String energyType;

	}

	/**
	 * 关系人信息-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Applicant implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 车主名称-字符
		 */
		private String ownerName;

		/**
		 * 车主联系方式-字符
		 */
		private String ownerPhone;

		/**
		 * 车主证件类型-字符
		 */
		private String ownerIdType;

		/**
		 * 车主证件号-字符
		 */
		private String ownerIdNo;

		/**
		 * 车主联系地址-字符
		 */
		private String ownerAddr;

		/**
		 * 车主出生日期(YYYY-MM-DD)-字符
		 */
		private String ownerBirthday;

		/**
		 * 车主性别(1男/2女)-数值
		 */
		private Integer ownerSex;

		/**
		 * 车主邮箱-字符
		 */
		private String ownerEmail;

		/**
		 * 投保人名称-字符
		 */
		private String holderName;

		/**
		 * 投保人联系方式-字符
		 */
		private String holderPhone;

		/**
		 * 投保人证件类型-字符
		 */
		private String holderIdType;

		/**
		 * 投保人证件号-字符
		 */
		private String holderIdNo;

		/**
		 * 投保人联系地址-字符
		 */
		private String holderAddr;

		/**
		 * 投保人出生日期(YYYY-MM-DD)-字符
		 */
		private String holderBirthday;

		/**
		 * 投保人性别(1男/2女)-数值
		 */
		private Integer holderSex;

		/**
		 * 被保人名称-字符
		 */
		private String insuredName;

		/**
		 * 被保人联系方式-字符
		 */
		private String insuredPhone;

		/**
		 * 被保人证件类型-字符
		 */
		private String insuredIdType;

		/**
		 * 被保人证件号-字符
		 */
		private String insuredIdNo;

		/**
		 * 被保人联系地址-字符
		 */
		private String insuredAddr;

		/**
		 * 被保人出生日期(YYYY-MM-DD)-字符
		 */
		private String insuredBirthday;

		/**
		 * 被保人性别(1男/2女)-数值
		 */
		private Integer insuredSex;

	}

	/**
	 * 险种信息-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Risks implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 险种代码 -字符
		 */
		private String riskCode;

		/**
		 * 险种名称-字符
		 */
		private String riskName;

		/**
		 * 保额-数值
		 */
		private BigDecimal amount;

		/**
		 * 保费-数值
		 */
		private BigDecimal premium;

		/**
		 * 数量(乘客险：车座数-1)-数值
		 */
		private Integer quantity;

		/**
		 * 单位保额(乘客险)-数值
		 */
		private BigDecimal unitAmount;

		/**
		 * 玻璃类型(投保玻璃险：0国产/1进口)-数值
		 */
		private Integer glassType;

		/**
		 * 是否投保不计免赔(0否/1是)-数值
		 */
		private Integer isDeductible;

		/**
		 * 不计免赔保费-数值
		 */
		private Integer deductPremium;

	}

}
