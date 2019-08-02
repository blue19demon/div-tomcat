package com.resp;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 功能：【悦保车险】核保及订单确认 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class InsureResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 基础信息-对象
	 */
	private BaseInfo baseInfo;

	/**
	 * 关系人信息-集合
	 */
	private List<Images> images;

	/**
	 * 扩展数据(接口扩展入参，兼容other)-对象
	 */
	private Extend extend;

	/**
	 * 基础信息
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class BaseInfo implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 投保单号-字符
		 */
		private String proposalNo;

		/**
		 * 交强险投保单号-字符
		 */
		private String tciProposalNo;

		/**
		 * 商业险投保单号-字符
		 */
		private String vciProposalNo;

		;
		/**
		 * 交强险保单状态-枚举
		 */
		private String tciPolicyStatus;

		/**
		 * 交强险保单状态描述-字符
		 */
		private String tciStatusMessage;

		/**
		 * 商业险保单状态-枚举
		 */
		private String vciPolicyStatus;

		/**
		 * 商业险保单状态描述-字符
		 */
		private String vciStatusMessage;

		/**
		 * 保单原因-字符
		 */
		private String reason;

		/**
		 * 保单状态-枚举
		 */
		private String policyStatus;

	}

	/**
	 * 文件列表
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Images implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 图片类型-字符
		 */
		private String type;

		/**
		 * 类型名称-字符
		 */
		private String typeName;

		/**
		 * 最少上传数量-枚举
		 */
		private Integer leastCount;

	}

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
