package com.req;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】计算车辆实际价格 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class GetActualPriceRequest implements Serializable {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 商业险保险起期(格式：yyyy-MM-dd)-字符-10-Y
	 */
	private String vciStartDate;

	/**
	 * 车辆初登日期(格式：yyyy-MM-dd)-字符-10-Y
	 */
	private String enrollDate;

	/**
	 * 新车购置价-Y
	 */
	private BigDecimal purchasePrice;

}
