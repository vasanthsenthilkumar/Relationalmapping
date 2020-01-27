
package com.fernbird.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employer")
@Getter
@Setter
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "employee_id")
	@JsonManagedReference
	public List<Address> addresses;

	public Employer() {
	}

	public Employer(int id, String name, String email, String city,String state) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city=city;
		this.state=state;
	}

}
