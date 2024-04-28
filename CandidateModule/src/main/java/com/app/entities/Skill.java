package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Skill {
	
	int sid;
	String name;
	
	
	int cid;

	public Skill() {
		super();
	}

	public Skill(String name, int cid) {
		this.name = name;
		this.cid = cid;
	}
	
	public Skill(int sid, String name, int cid) {
		super();
		this.sid = sid;
		this.name = name;
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Skill [sid=" + sid + ", name=" + name + ", cid=" + cid + "]";
	}
	
	
}
