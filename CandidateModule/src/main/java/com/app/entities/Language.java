package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


public class Language {
	
	
	int pid;
	String name;
	

	int cid;
	
	public Language() {
		super();
	}
	
	
	public Language(int pid, String name, int cid) {
		super();
		this.pid = pid;
		this.name = name;
		this.cid = cid;
	}


	public Language(String name, int cid) {
		super();
		this.name = name;
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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
		return "Language [pid=" + pid + ", name=" + name + ", cid=" + cid + "]";
	}
	
	
}
