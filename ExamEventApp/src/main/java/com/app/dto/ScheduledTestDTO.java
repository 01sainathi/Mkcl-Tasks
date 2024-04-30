package com.app.dto;

import java.util.Date;

public class ScheduledTestDTO {
	
	String ename;
	String pname;
	Date sdate;
	Date edate;
	public ScheduledTestDTO() {
		super();
	}
	public ScheduledTestDTO(String ename, String pname, Date sdate, Date edate) {
		super();
		this.ename = ename;
		this.pname = pname;
		this.sdate = sdate;
		this.edate = edate;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	@Override
	public String toString() {
		return "ScheduledTestDTO [ename=" + ename + ", pname=" + pname + ", sdate=" + sdate + ", edate=" + edate + "]";
	}
	
}
