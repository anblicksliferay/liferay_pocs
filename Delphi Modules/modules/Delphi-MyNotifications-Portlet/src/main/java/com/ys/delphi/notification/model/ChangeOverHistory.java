package com.ys.delphi.notification.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;

public class ChangeOverHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private String partNumber;
	private String productType;
	private String productFamily;
	private BigDecimal cycleTime;

	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("productType", productType);
		json.put("productFamily", productFamily);
		json.put("partNumber", partNumber);
		json.put("cycleTime", cycleTime.longValue());
		return json;
	}

	public ChangeOverHistory(String partNumber, String productType,
			String productFamily, BigDecimal cycleTime) {
		super();
		this.partNumber = partNumber;
		this.productType = productType;
		this.productFamily = productFamily;
		this.cycleTime = cycleTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public String getProductType() {
		return productType;
	}

	public String getProductFamily() {
		return productFamily;
	}

	public BigDecimal getCycleTime() {
		return cycleTime;
	}

	@Override
	public String toString() {
		return "ChangeOverHistory [partNumber=" + partNumber + ", productType="
				+ productType + ", productFamily=" + productFamily
				+ ", cycleTime=" + cycleTime + "]";
	}

}
