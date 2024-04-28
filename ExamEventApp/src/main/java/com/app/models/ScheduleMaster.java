package com.app.models;

import java.util.Date;

public class ScheduleMaster {

	private long scheduleID;
	private String scheduleName;
	private Date scheduleStart;
	private Date scheduleEnd;
	private Boolean isActiveSchedule;
	
	private String createdBy;
	private Date dateCreated;
	
	private String modifiedBy;
	private Date dateModified;
	private long fkExamEventID;
	private char deleted;
	private String scheduleType;
	private Boolean allowScheduleExtension;	
	private int maxNumberOfPapers;
	public ScheduleMaster() {
		super();
	}
	public ScheduleMaster(long scheduleID, String scheduleName, Date scheduleStart, Date scheduleEnd,
			Boolean isActiveSchedule, String createdBy, Date dateCreated, String modifiedBy, Date dateModified,
			long fkExamEventID, char deleted, String scheduleType, Boolean allowScheduleExtension,
			int maxNumberOfPapers) {
		super();
		this.scheduleID = scheduleID;
		this.scheduleName = scheduleName;
		this.scheduleStart = scheduleStart;
		this.scheduleEnd = scheduleEnd;
		this.isActiveSchedule = isActiveSchedule;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.fkExamEventID = fkExamEventID;
		this.deleted = deleted;
		this.scheduleType = scheduleType;
		this.allowScheduleExtension = allowScheduleExtension;
		this.maxNumberOfPapers = maxNumberOfPapers;
	}
	
	
	public ScheduleMaster(Date scheduleStart, Date scheduleEnd, String createdBy, Date dateCreated, long fkExamEventID,
			String scheduleType, int maxNumberOfPapers) {
		super();
		this.scheduleStart = scheduleStart;
		this.scheduleEnd = scheduleEnd;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.fkExamEventID = fkExamEventID;
		this.scheduleType = scheduleType;
		this.maxNumberOfPapers = maxNumberOfPapers;
	}
	public long getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(long scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public Date getScheduleStart() {
		return scheduleStart;
	}
	public void setScheduleStart(Date scheduleStart) {
		this.scheduleStart = scheduleStart;
	}
	public Date getScheduleEnd() {
		return scheduleEnd;
	}
	public void setScheduleEnd(Date scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}
	public Boolean getIsActiveSchedule() {
		return isActiveSchedule;
	}
	public void setIsActiveSchedule(Boolean isActiveSchedule) {
		this.isActiveSchedule = isActiveSchedule;
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
	public long getFkExamEventID() {
		return fkExamEventID;
	}
	public void setFkExamEventID(long fkExamEventID) {
		this.fkExamEventID = fkExamEventID;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public String getScheduleType() {
		return scheduleType;
	}
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
	public Boolean getAllowScheduleExtension() {
		return allowScheduleExtension;
	}
	public void setAllowScheduleExtension(Boolean allowScheduleExtension) {
		this.allowScheduleExtension = allowScheduleExtension;
	}
	public int getMaxNumberOfPapers() {
		return maxNumberOfPapers;
	}
	public void setMaxNumberOfPapers(int maxNumberOfPapers) {
		this.maxNumberOfPapers = maxNumberOfPapers;
	}
	@Override
	public String toString() {
		return "{\"scheduleID\":\"" + scheduleID + "\","
				+ "\"scheduleName\":\"" + scheduleName + "\","
				+ "\"scheduleStart\":\""+ scheduleStart + "\","
				+ "\"scheduleEnd\":\"" + scheduleEnd + "\","
				+ "\"isActiveSchedule\":\"" + isActiveSchedule+"\","
				+ " \"createdBy\":\"" + createdBy + "\","
				+ "\"dateCreated\":\"" + dateCreated + "\","
				+ " \"modifiedBy\":\"" + modifiedBy	+ "\","
				+ " \"dateModified\":\"" + dateModified + "\","
				+ "\"fkExamEventID\":\"" + fkExamEventID + "\","
				+ "\"deleted\":\"\","
				+ " \"scheduleType\":\"" + scheduleType + "\","
				+ " \"allowScheduleExtension\":\"" + allowScheduleExtension+ "\", "
				+ "\"maxNumberOfPapers\":\"" + maxNumberOfPapers + "\"}";
	}
	
	
}

