package springboot.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitBeanInOut {

	@JsonProperty
	private String unitName;

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
	
}
