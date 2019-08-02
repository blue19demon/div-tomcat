package com.resp;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * 功能：【悦保车险】保单信息查询 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QueryPolicyInfoResponseData implements Serializable {

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
	 * 保单状态-数值 保单状态 状态说明 0 报价失败 1 报价成功 2 下发修改 3 人工审核 4 核保成功 5 支付失败 6 支付成功 7 承保失败 8 承保成功
	 */
	private String policyStatus;

	/**
	 * 报价失败原因/核保失败原因-字符
	 */
	private String reason;

}