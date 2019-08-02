package com;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.comm.ApiUrls;
import com.comm.Response;
import com.req.GetActualPriceRequest;
import com.req.InsureRequest;
import com.req.LoginRequest;
import com.req.PaymentRequest;
import com.req.QueryCompanyRequest;
import com.req.QueryModelRequest;
import com.req.QueryPolicyInfoRequest;
import com.req.QueryRenewalRequest;
import com.req.QuoteRequest;
import com.req.UploadImageRequest;
import com.req.UploadImageRequest.Images;
import com.resp.GetActualPriceResponseData;
import com.resp.InsureResponseData;
import com.resp.LoginResponseData;
import com.resp.PaymentResponseData;
import com.resp.QueryCompanyResponseData;
import com.resp.QueryOrganizationResponseData;
import com.resp.QueryPolicyConfigResponseData;
import com.resp.QueryPolicyInfoResponseData;
import com.resp.QueryRenewalResponseData;
import com.resp.QueryRiskConfigResponseData;
import com.resp.QuoteResponseData;
import com.tools.UnirestTools;

import app.Application;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 单元测试
 *
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@Slf4j
public class ApplicationTest {

	private String header = "Bearer 98b685d1-3647-41b4-8747-c84ace427d15";

	/**
	 * 登陆 所有API请求,除登录前，需要获取用户授权登录token
	 */
	@Test
	public void exucteLogin() {
		Object param = LoginRequest.builder().username("")
				.password("").channelCode("")
				.build();
		this.header = null;
		Response<LoginResponseData> resp = UnirestTools.builder().url(ApiUrls.LOGIN)
				.param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 平台属性
	 */
	@Test
	public void exucteQueryPolicyConfig() {
		Object param = null;

		Response<QueryPolicyConfigResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.QUERY_POLICY_CONFIG).param(param).header(header).build()
				.doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 平台险种配置
	 */
	@Test
	public void exucteQueryRiskConfig() {
		Object param = null;
		Response<QueryRiskConfigResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.QUERY_RISK_CONFIG).param(param).header(header).build()
				.doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 根据客户提供的工号，返回机构网点
	 */
	@Test
	public void exucteQueryOrganization() {
		Object param = null;
		Response<QueryOrganizationResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.QUERY_ORGANIZATION).param(param).header(header).build()
				.doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 根据选择的机构网点，查询可用保险公司
	 */
	@Test
	public void exucteQueryCompany() {
		Object param = QueryCompanyRequest.builder()
				.organizationId("b207c540ad3211e9818300163e08a24e").build();
		Response<QueryCompanyResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.QUERY_COMPANY).param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 根据车牌或车架号查询往年续保数据
	 */
	@Test
	public void exucteQueryRenewal() {
		Object param = QueryRenewalRequest.builder()
				.organizationId("b207c540ad3211e9818300163e08a24e").licenseNo("豫JMK050")
				.cardLastNo("117012").frameNo("LGBM4AE44JS583***")
				.callbackUrl("http://www.baidu.com").build();
		Response<QueryRenewalResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.QUERY_RENEWAL).param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 登根据品牌型号或车架号查询车辆数据
	 */
	@Test
	public void exucteQueryModel() {
		Object param = QueryModelRequest.builder().brandName("东风日产DFL6460VANM5多用途乘用车")
				.frameNo("").enrollDate("").build();
		Response<QueryRenewalResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.QUERY_MODEL).param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 计算车辆实际价格
	 */
	@Test
	public void exucteGetActualPrice() {
		Object param = GetActualPriceRequest.builder().vciStartDate("2019-10-01")
				.enrollDate("2020-10-01").purchasePrice(new BigDecimal(120000)).build();
		Response<GetActualPriceResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.GET_ACTUAL_PRICE).param(param).header(header).build()
				.doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 保费计算
	 */
	@Test
	public void exucteQuote() {
		Object param = QuoteRequest.builder().build();
		Response<QuoteResponseData> resp = UnirestTools.builder().url(ApiUrls.QUOTE)
				.param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 核保及订单确认
	 */
	@Test
	public void exucteInsure() {
		Object param = InsureRequest.builder().build();
		Response<InsureResponseData> resp = UnirestTools.builder().url(ApiUrls.INSURE)
				.param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 核保通过后的订单可提交支付申请
	 */
	@Test
	public void exuctePayment() {
		Object param = PaymentRequest.builder().build();
		Response<PaymentResponseData> resp = UnirestTools.builder().url(ApiUrls.PAYMENT)
				.param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 影像上传
	 */
	@Test
	public void exucteUploadImage() {
		Object param = UploadImageRequest.builder().orderId("2")
				.images(Arrays.asList(Images.builder().type("1").link("3").build(),
						Images.builder().type("11").link("32").build(),
						Images.builder().type("11").link("32").build()))
				.build();
		Response<?> resp = UnirestTools.builder().url(ApiUrls.UPLOAD_IMAGE)
				.requestWithJson(true).param(param).header(header).build().doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

	/**
	 * 保单信息查询
	 */
	@Test
	public void exucteQueryPolicyInfo() {
		Object param = QueryPolicyInfoRequest.builder().orderId("2").build();
		Response<QueryPolicyInfoResponseData> resp = UnirestTools.builder()
				.url(ApiUrls.QUERY_POLICY_INFO).param(param).header(header).build()
				.doPost();
		if (resp.isSuccess()) {
			log.info("响应结果:");
			log.info(JSONObject.toJSONString(resp.getData(), true));
		}
		else {
			log.info("响应结果:" + resp.getMessage());
		}
	}

}
