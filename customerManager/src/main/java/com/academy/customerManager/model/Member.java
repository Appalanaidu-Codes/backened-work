package com.academy.customerManager.model;

import jakarta.persistence.*;

@Entity

@Table(name = "Customer_Data")

public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PHONE")
	private long phone;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "PRODUCT")
	private String product;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "ADDRESS")
	private String address;
	
	
	public Member()
	{
		//constructor
	}
	
	public Member(String name, long phone, int age, String product, int quantity, String address) {
		
		super();
		
		this.name=name;
		this.phone=phone;
		this.age=age;
		this.product=product;
		this.quantity=quantity;
		this.address=address;
		
		
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public long getPhone() {
		return phone;
	}




	public void setPhone(long phone) {
		this.phone = phone;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getProduct() {
		return product;
	}




	public void setProduct(String product) {
		this.product = product;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}
	

}
