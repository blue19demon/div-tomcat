package com.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】根据车牌或车架号查询往年续保数据 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class QueryRenewalRequest implements Serializable {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 机构网点编码(选择网点，根据网点绑定工号查询续保)-字符-32-Y
	 */
	private String organizationId;

	/**
	 * 车牌号(用车牌号查询时必填)-字符-10-CY
	 */
	private String licenseNo;

	/**
	 * 车主身份证后6位(用车牌号查询时有值会更准确)-字符-6-CY
	 */
	private String cardLastNo;

	/**
	 * 车架号/vin(用车架号查询时必填 车牌号与车架号查询只取其一)-字符-17-CY
	 */
	private String frameNo;

	/**
	 * 回调地址(异步回调模式必填；地址必须加入平台白名单)-字符-50-CY
	 */
	private String callbackUrl;

}
