package com.req;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 *
 * 功能：【悦保车险】影像上传 请求参数
 *
 * @author Administrator
 *
 */
@Data
@Builder
public class UploadImageRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单号(报价返回的订单号)-字符-50-Y
	 */
	private String orderId;

	/**
	 * 图片数据-集合-Y
	 */
	private List<Images> images;

	/**
	 * 图片数据
	 *
	 * @author Administrator
	 *
	 */
	@Data
	@Builder
	public static class Images implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 图片类型-字符-Y
		 */
		private String type;

		/**
		 * 类型名称-字符-Y
		 */
		private String link;

	}

}
