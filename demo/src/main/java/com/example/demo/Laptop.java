package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	private int lapid;
	private String brand;
	public int getLapid() {
		return lapid;
	}
	public void setLapid(int lapid) {
		this.lapid = lapid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "Laptop [lapid=" + lapid + ", brand=" + brand + "]";
	}
	
	public void laptopclass() {
		System.out.println("Laptop Class");
	}
	
	
}
