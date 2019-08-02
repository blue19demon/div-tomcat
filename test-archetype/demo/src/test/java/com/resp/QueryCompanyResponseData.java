package com.resp;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 功能：【悦保车险】根据选择的机构网点，查询可用保险公司 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QueryCompanyResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 结果集-集合
	 */
	private List<QueryCompany> list;

	/**
	 * 平台险种配置Item
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class QueryCompany {

		/**
		 * 保险公司id
		 */
		private Integer id;

		/**
		 * 保险公司名称
		 */
		private String name;

		/**
		 * 工号id
		 */
		private String channelId;

		/**
		 * 工号名称
		 */
		private String channelName;

	}

}
