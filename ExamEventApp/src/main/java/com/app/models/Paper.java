package com.app.models;

import java.sql.Date;
import java.util.List;

public class Paper
{
	private long paperID;
	private long fkClientID;
	private String code;

	private String name;

	private String duration;
	private boolean isPublished;
	
	private char deleted; 
	private String Total_Marks_Check;
	
	private String createdBy;
	private Date dateCreated;
	
	private String modifiedBy;
	private Date dateModified;
	public Paper() {
		super();
	}
	public Paper(long paperID, long fkClientID, String code, String name, String duration, boolean isPublished,
			char deleted, String total_Marks_Check, String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified) {
		super();
		this.paperID = paperID;
		this.fkClientID = fkClientID;
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.isPublished = isPublished;
		this.deleted = deleted;
		Total_Marks_Check = total_Marks_Check;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}
	
	
	public long getPaperID() {
		return paperID;
	}
	public void setPaperID(long paperID) {
		this.paperID = paperID;
	}
	public long getFkClientID() {
		return fkClientID;
	}
	public void setFkClientID(long fkClientID) {
		this.fkClientID = fkClientID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public String getTotal_Marks_Check() {
		return Total_Marks_Check;
	}
	public void setTotal_Marks_Check(String total_Marks_Check) {
		Total_Marks_Check = total_Marks_Check;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	@Override
	public String toString() {
		return "{\"paperID\":\"" + paperID + "\", \"code\":\"" + code + "\", \"name\":\"" + name
				+ "\"}";
	}
}

