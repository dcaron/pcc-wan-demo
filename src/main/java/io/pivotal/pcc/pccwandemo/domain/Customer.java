package io.pivotal.pcc.pccwandemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("customer")
public class Customer {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String address;
	private String birthday;
	private String region;
	private Integer index;

	public Customer() {}

	public Customer(String name, String email, String address, String birthday, String region, Integer index) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.region = region;
		this.index = index;
		this.id = region + "-customer-" + index;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", birthday=" + birthday + "]";
	}
}
