package com.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * 功能：【悦保车险】根据品牌型号或车架号查询车辆数据 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QueryModelResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 结果集-集合
	 */
	private List<QueryModel> list;

	/**
	 * 车型查询结果对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class QueryModel {

		/**
		 * 精友车型编码-字符
		 */
		private String jyModelCode;

		/**
		 * 车型编码-字符
		 */
		private String modelCode;

		/**
		 * 排量/功率-数值
		 */
		private Float displacement;

		/**
		 * 品牌型号-字符
		 */
		private String brandName;

		/**
		 * 新车价格-数值
		 */
		private BigDecimal purchasePrice;

		/**
		 * 年款-字符
		 */
		private String issueYear;

		/**
		 * 座位数-数值
		 */
		private Integer seatCount;

	}

}
