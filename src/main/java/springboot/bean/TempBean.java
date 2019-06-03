package springboot.bean;

public class TempBean {

	private Long Id;
	private String name;
	private String city;
	private String phone;

	public TempBean() {

	}

	public TempBean(String name, String city, String phone) {
		this.name = name;
		this.city = city;
		this.phone = phone;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "TempBean [Id=" + Id + ", name=" + name + ", city=" + city + ", phone=" + phone + "]";
	}
	
	

}
