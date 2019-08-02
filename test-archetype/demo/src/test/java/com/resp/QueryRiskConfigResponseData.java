package com.resp;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 功能：【悦保车险】平台险种配置 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QueryRiskConfigResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 结果集-集合
	 */
	private List<QueryRiskConfig> list;

	/**
	 * 平台险种配置Item
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class QueryRiskConfig {

		/**
		 * 险别代码-字符
		 */
		private String code;

		/**
		 * 险别名称-字符
		 */
		private String name;

		/**
		 * 是否有不计免赔（0否/1是）-枚举
		 */
		private String sdew;

		/**
		 * 排序-数值
		 */
		private Integer sort;

		/**
		 * 险别全称-字符
		 */
		private String fullName;

		/**
		 * 选择列表-集合
		 */
		private List<Select> select;

		/**
		 * 选择列表Item
		 *
		 * @author Administrator
		 */
		@Data
		class Select {

			/**
			 * 显示值
			 */
			private String name;

			/**
			 * 接口传递值
			 */
			private String value;

		}

	}

}
