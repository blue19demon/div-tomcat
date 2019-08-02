package com.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * 功能：【悦保车险】保费计算 响应Data格式
 *
 * @author Administrator
 *
 */
@Data
public class QuoteResponseData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 基础信息-对象-Y
	 */
	private BaseInfo baseInfo;

	/**
	 * 商业险险别信息(投保商业险必传)-集合-CY
	 */
	private List<QuoteRisks> risks;

	/**
	 * 车辆信息-对象-Y
	 */
	private VehicleInfo vehicleInfo;

	/**
	 * 投保查询校验信息(投保查询校验时必传)-集合-CY
	 */
	private List<Checks> checks;

	/**
	 * 江苏交管车辆校验信息(江苏交管车辆校验时必传)-对象-CY
	 */
	private VehicleCheckInfo vehicleCheckInfo;

	/**
	 * 关系人信息-集合-Y
	 */
	private List<Images> images;

	/**
	 * 扩展数据(接口扩展入参，兼容other)-对象-Y
	 */
	private Extend extend;

	/**
	 * 基础信息
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class BaseInfo implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 订单号-字符
		 */
		private String orderId;

		/**
		 * 总保费-数值
		 */
		private BigDecimal totalPremium;

		/**
		 * 交强险保费-数值
		 */
		private BigDecimal tciPremium;

		/**
		 * 商业险保费-数值
		 */
		private BigDecimal vciPremium;

		/**
		 * 车船税-数值
		 */
		private BigDecimal vehicleTax;

		/**
		 * 交强险出险次数(允许负值；负值代表连续几年未出险；正值代表上年出险几次；0代表新车；空代表没查到)-数值
		 */
		private Integer tciLossOccurredCount;

		/**
		 * 商业险出险次数(允许负值；负值代表连续几年未出险；正值代表上年出险几次；0代表新车；空代表没查到)-数值
		 */
		private Integer vciLossOccurredCount;

		/**
		 * 交强险折扣-数值
		 */
		private BigDecimal tciDiscount;

		/**
		 * 商业险折扣 -数值
		 */
		private BigDecimal vciDiscount;

		/**
		 * 交强险保险起期(格式：YYYY-MM-DD)-字符
		 */
		private String tciStartDate;

		/**
		 * 商业险保险起期(格式：YYYY-MM-DD)-字符
		 */
		private String vciStartDate;

		/**
		 * 是否代缴车船税(云南阳光需要)-字符
		 */
		private String taxReliefFlag;

		/**
		 * 太平洋商业险分类(太平洋报价返回)-字符
		 */
		private String cpicVciClassify;

		/**
		 * 交强险评分-数值
		 */
		private Float tciScore;

		/**
		 * 商业险评分-数值
		 */
		private Float vciScore;

		/**
		 * 合计评分-数值
		 */
		private Float totalScore;

	}

	/**
	 * 险种列表
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class QuoteRisks implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 险别代码-字符
		 */
		private String riskCode;

		/**
		 * 险别名称-字符
		 */
		private String riskName;

		/**
		 * 保额-数值
		 */
		private BigDecimal amount;

		/**
		 * 保费-数值
		 */
		private BigDecimal premium;

		/**
		 * 座位数-数值
		 */
		private Integer quantity;

		/**
		 * 每座保险金额-数值
		 */
		private BigDecimal unitAmount;

		/**
		 * 玻璃类型-枚举
		 */
		private String glassType;

		/**
		 * 不计免赔保费-数值
		 */
		private BigDecimal deductPremium;

	}

	/**
	 * 车辆信息-对象
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class VehicleInfo implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 车型名称-字符
		 */
		private String brandName;

		/**
		 * 车型编码-字符
		 */
		private String modelCode;

		/**
		 * 车架号/vin-字符
		 */
		private String frameNo;

		/**
		 * 发动机号-字符
		 */
		private String engineNo;

		/**
		 * 车型年款-字符
		 */
		private String issueYear;

		/**
		 * 新车价格-数值
		 */
		private BigDecimal purchasePrice;

		/**
		 * 座位数-数值
		 */
		private Integer seatCount;

		/**
		 * 排量/功率-数值
		 */
		private Float displacement;

	}

	/**
	 * 投保查询校验信息
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Checks implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 校验类型标志(0非转保业务/1转保业务；)-枚举
		 */
		private String renewalFlag;

		/**
		 * 校验类别(0交强险转保车验证码/1商业险转保车验证码)-枚举-Y
		 */
		private String checkFlag;

		/**
		 * 查询码-字符
		 */
		private String checkNo;

		/**
		 * 验证码-字符
		 */
		private String checkCode;

	}

	/**
	 * 江苏交管车辆校验信息
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class VehicleCheckInfo implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 查询码-字符
		 */
		private String checkNo;

		/**
		 * 验证码-字符
		 */
		private String checkCode;

	}

	/**
	 * 文件列表
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Images implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 图片类型-字符
		 */
		private String type;

		/**
		 * 类型名称-字符
		 */
		private String typeName;

		/**
		 * 最少上传数量-枚举
		 */
		private Integer leastCount;

	}

	/**
	 * 扩展返回结果数据
	 *
	 * @author Administrator
	 *
	 */
	@Data
	class Extend implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 校验码(base64图片校验码)-字符
		 */
		private String checkCode;

	}

}
