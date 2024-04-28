package com.app.models;

public class City {
	int id;
	String city_name;
	int sid;
	public City() {
		super();
	}
	public City(int id, String city_name, int sid) {
		super();
		this.id = id;
		this.city_name = city_name;
		this.sid = sid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"city_name\":\"" + city_name + "\", \"sid\":\"" + sid + "\"}";
	}
	
	
}
