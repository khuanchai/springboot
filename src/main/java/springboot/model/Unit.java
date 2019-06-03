package springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_unit")
public class Unit implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unit_id", length = 11, nullable = false)
	private Long unitId;

	@Column(name = "unit_name", length = 255, nullable = false)
	private String unitName;

	@Column(name = "type", length = 100, nullable = false)
	private String unitType;

	public Unit() {

	}

	public Unit(Long unitId, String unitName, String unitType) {
		this.unitName = unitName;
		this.unitType = unitType;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", unitName=" + unitName + ", unitType=" + unitType + "]";
	}

}
