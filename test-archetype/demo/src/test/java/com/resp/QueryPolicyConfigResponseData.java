package com.resp;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 *
 * 功能：【悦保车险】平台基础属性 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QueryPolicyConfigResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 车辆类型-集合
	 */
	private List<KeyValueEntity> vehicleType;

	/**
	 * 车辆种类-集合
	 */
	private List<KeyValueEntity> vehicleCategory;

	/**
	 * 车辆使用性质-集合
	 */
	private List<KeyValueEntity> useNature;

	/**
	 * 车辆使用性质细分-集合
	 */
	private List<KeyValueEntity> attachNature;

	/**
	 * 号牌种类-集合
	 */
	private List<KeyValueEntity> plateType;

	/**
	 * 号牌底色-集合
	 */
	private List<KeyValueEntity> plateColor;

	/**
	 * 能源类型-集合
	 */
	private List<KeyValueEntity> energyType;

	/**
	 * 证件类型-集合
	 */
	private List<KeyValueEntity> certificateType;

	/**
	 *
	 * 集合内部对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class KeyValueEntity implements Serializable {

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
		 * 父节点-字符
		 */
		private String parent;

	}

}
