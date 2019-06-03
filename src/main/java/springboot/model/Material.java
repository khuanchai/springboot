package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_material")
public class Material {

	@Id
	@Column(name = "material_id", length = 11, unique = true, nullable = false)
	private Long materialId;

	@Column(name = "material_tname", length = 255, nullable = false)
	private String materialTname;

	@Column(name = "material_cost", length = 11, precision = 2, nullable = false)
	private float materialCost;

	@Column(name = "material_unit", length = 255, nullable = false)
	private String materialUnit;

	@Column(name = "type_material_id", length = 50, nullable = false)
	private String typeMaterialId;

	@Column(name = "material_stock_amount", length = 11, precision = 2, nullable = false)
	private float materialStockAmount;

	@Column(name = "material_stock_unit", length = 255, nullable = false)
	private String materialStockUnit;

	@Column(name = "material_action", length = 11, nullable = false)
	private Long materialAction;

	@Transient
	private String typeMaterialTname;

	public Material() {
		// TODO Auto-generated constructor stub
	}

	public Material(Long materialId, String materialTname, float materialCost, String materialUnit,
			String typeMaterialId, float materialStockAmount, String materialStockUnit, Long materialAction) {
		this.materialId = materialId;
		this.materialTname = materialTname;
		this.materialCost = materialCost;
		this.materialUnit = materialUnit;
		this.typeMaterialId = typeMaterialId;
		this.materialStockAmount = materialStockAmount;
		this.materialStockUnit = materialStockUnit;
		this.materialAction = materialAction;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getMaterialTname() {
		return materialTname;
	}

	public void setMaterialTname(String materialTname) {
		this.materialTname = materialTname;
	}

	public float getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(float materialCost) {
		this.materialCost = materialCost;
	}

	public String getMaterialUnit() {
		return materialUnit;
	}

	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}

	public String getTypeMaterialId() {
		return typeMaterialId;
	}

	public void setTypeMaterialId(String typeMaterialId) {
		this.typeMaterialId = typeMaterialId;
	}

	public float getMaterialStockAmount() {
		return materialStockAmount;
	}

	public void setMaterialStockAmount(float materialStockAmount) {
		this.materialStockAmount = materialStockAmount;
	}

	public String getMaterialStockUnit() {
		return materialStockUnit;
	}

	public void setMaterialStockUnit(String materialStockUnit) {
		this.materialStockUnit = materialStockUnit;
	}

	public Long getMaterialAction() {
		return materialAction;
	}

	public void setMaterialAction(Long materialAction) {
		this.materialAction = materialAction;
	}

	public String getTypeMaterialTname() {
		return typeMaterialTname;
	}

	public void setTypeMaterialTname(String typeMaterialTname) {
		this.typeMaterialTname = typeMaterialTname;
	}

	@Override
	public String toString() {
		return "Material [materialId=" + materialId + ", materialTname=" + materialTname + ", materialCost="
				+ materialCost + ", materialUnit=" + materialUnit + ", typeMaterialId=" + typeMaterialId
				+ ", materialStockAmount=" + materialStockAmount + ", materialStockUnit=" + materialStockUnit
				+ ", materialAction=" + materialAction + ", typeMaterialTname=" + typeMaterialTname + "]";
	}

}
