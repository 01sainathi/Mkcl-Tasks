package com.app.CandidateApp.models;

public class Candidate {
	int id;
	String fName;
	String lName;
	String email;
	String mob;
	
	public Candidate() {
	}
	
	public Candidate(int id, String fName, String lName, String email, String mob) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.mob = mob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", mob=" + mob
				+ "]";
	}
}
