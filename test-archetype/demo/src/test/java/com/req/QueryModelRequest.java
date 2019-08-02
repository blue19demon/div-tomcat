package com.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】根据品牌型号或车架号查询车辆数据 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class QueryModelRequest implements Serializable {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌型号(和frameNo二选一)-字符-N
	 */
	private String brandName;

	/**
	 * 车架号/vin(和brandName二选一)-字符-N
	 */
	private String frameNo;

	/**
	 * 车辆初登日期(格式：yyyy-MM-dd可根据初登日期过滤掉车型)-字符-N
	 */
	private String enrollDate;

}
