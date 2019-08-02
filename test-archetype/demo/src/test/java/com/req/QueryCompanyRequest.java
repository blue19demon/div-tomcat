package com.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】根据选择的机构网点，查询可用保险公司 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class QueryCompanyRequest implements Serializable {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 机构网点编码-字符-32-Y
	 */
	private String organizationId;

}
