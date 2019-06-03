package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_type_material")
public class MaterialCategory {

	@Id
	@Column(name = "type_material_id", length = 50, nullable = false, unique = true)
	private String typeMaterialId;

	@Column(name = "type_material_tname", length = 255, nullable = false)
	private String typeMaterialTname;

	@Column(name = "type_material_description")
	private String typeMaterialDescription;

	@Column(name = "type_material_action", nullable = false)
	private Long typeMaterialAction;

	public MaterialCategory() {

	}

	public MaterialCategory(String typeMaterialId, String typeMaterialTname, String typeMaterialDescription,
			Long typeMaterialAction) {

		this.typeMaterialId = typeMaterialId;
		this.typeMaterialTname = typeMaterialTname;
		this.typeMaterialDescription = typeMaterialDescription;
		this.typeMaterialAction = typeMaterialAction;
	}

	public String getTypeMaterialId() {
		return typeMaterialId;
	}

	public void setTypeMaterialId(String typeMaterialId) {
		this.typeMaterialId = typeMaterialId;
	}

	public String getTypeMaterialTname() {
		return typeMaterialTname;
	}

	public void setTypeMaterialTname(String typeMaterialTname) {
		this.typeMaterialTname = typeMaterialTname;
	}

	public String getTypeMaterialDescription() {
		return typeMaterialDescription;
	}

	public void setTypeMaterialDescription(String typeMaterialDescription) {
		this.typeMaterialDescription = typeMaterialDescription;
	}

	public Long getTypeMaterialAction() {
		return typeMaterialAction;
	}

	public void setTypeMaterialAction(Long typeMaterialAction) {
		this.typeMaterialAction = typeMaterialAction;
	}

	@Override
	public String toString() {
		return "MaterialCategory [typeMaterialId=" + typeMaterialId + ", typeMaterialTname=" + typeMaterialTname
				+ ", typeMaterialDescription=" + typeMaterialDescription + ", typeMaterialAction=" + typeMaterialAction
				+ "]";
	}

	
	
}
