package org.hibernate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name = "good_wheel")
	private String goodWheel;
	
	public Company() {}
	
	public Company(int id, String name, String goodWheel) {
		super();
		this.id = id;
		this.name = name;
		this.goodWheel = goodWheel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoodWheel() {
		return goodWheel;
	}
	public void setGoodWheel(String goodWheel) {
		this.goodWheel = goodWheel;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", name=" + name + ", goodWheel=" + goodWheel + "]";
	}
	
}
