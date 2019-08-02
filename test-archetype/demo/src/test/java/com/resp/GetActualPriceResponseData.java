package com.resp;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * 功能：【悦保车险】计算车辆实际价格 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class GetActualPriceResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 车辆实际价格-数值
	 */
	private BigDecimal actualPrice;

}