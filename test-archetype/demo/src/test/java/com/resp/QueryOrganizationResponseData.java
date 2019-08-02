package com.resp;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 功能：【悦保车险】根据客户提供的工号，返回机构网点 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QueryOrganizationResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 结果集-集合
	 */
	private List<QueryOrganization> list;

	/**
	 *
	 * 集合内部对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class QueryOrganization implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 显示名称-字符
		 */
		private String name;

		/**
		 * 接口传递-字符
		 */
		private String value;

		/**
		 * 省份简称-字符
		 */
		private String area;

		/**
		 * 父节点-字符
		 */
		private String parent;

	}

}
