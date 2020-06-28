package com.crm.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lead")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private Integer id;

	@Column(name = "first_name")
	@JsonAlias({ "first_name", "first_name" })
	@NotEmpty(message = "First name must not be empty")
	private String firstName;

	@Column(name = "last_name")
	@JsonAlias({ "last_name", "last_name" })
	@NotEmpty(message = "Last name must not be empty")
	private String lastName;

	@Column(name = "mobile", unique = true)
	@NotEmpty(message = "Mobile must not be empty")
	@Size(min = 10, message = "Mobile should have atleast 2 characters")
	private String mobile;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "location_type")
	@JsonAlias({ "location_type", "location_type" })
	private String locationType;

	@Column(name = "location_string")
	@JsonAlias({ "location_string", "location_string" })
	private String locationString;

	@Column(name = "status")
	private String status;

	@JsonIgnore
	@Column(name = "communication")
	private String communication;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	public String getStatus() {
		return status;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@Override
	public String toString() {
		return "Lead [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", locationType=" + locationType + ", locationString=" + locationString
				+ ", status=" + status + ", communication=" + communication + "]";
	}

}
