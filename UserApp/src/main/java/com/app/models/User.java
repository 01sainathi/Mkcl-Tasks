package com.app.models;

public class User {
	int id;
	String name;
	String email;
	int sid;
	int cid;
	public User() {
		super();
	}
	public User(int id, String name, String email, int sid, int cid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.sid = sid;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", sid=" + sid + ", cid=" + cid + "]";
	}
}
