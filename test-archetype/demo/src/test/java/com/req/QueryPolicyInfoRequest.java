package com.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】保单信息查询 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class QueryPolicyInfoRequest implements Serializable {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 订单号(报价返回的订单号)-字符-50-Y
	 */
	private String orderId;

}
