package com.app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class ExamEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	private long examEventID;
	private long clientID;
	private String defaultLanguageID;
	private String examEventCode;
	private String name;

	private Date startDate;
	private Date endDate;
	private Boolean isActiveEvent;

	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

//	private transient List<ExamEventPaperDetails> listExamEventPaperDetails;

	private String eventCategory;
	
	private String eventType;

	private Boolean examEventState;

	public ExamEvent() {
		super();
	}

	public ExamEvent(long examEventID, long clientID, String defaultLanguageID, String examEventCode, String name,
			Date startDate, Date endDate, Boolean isActiveEvent, String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, String eventCategory, String eventType, Boolean examEventState) {
		super();
		this.examEventID = examEventID;
		this.clientID = clientID;
		this.defaultLanguageID = defaultLanguageID;
		this.examEventCode = examEventCode;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActiveEvent = isActiveEvent;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.eventCategory = eventCategory;
		this.eventType = eventType;
		this.examEventState = examEventState;
	}
	
	public ExamEvent(String defaultLanguageID, String examEventCode, String name, Date startDate, Date endDate) {
		super();
		this.defaultLanguageID = defaultLanguageID;
		this.examEventCode = examEventCode;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ExamEvent(long clientID, String defaultLanguageID, String examEventCode, String name, Date startDate,
			Date endDate, String createdBy, Date dateCreated) {
		super();
		this.clientID = clientID;
		this.defaultLanguageID = defaultLanguageID;
		this.examEventCode = examEventCode;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public long getExamEventID() {
		return examEventID;
	}

	public void setExamEventID(long examEventID) {
		this.examEventID = examEventID;
	}

	public long getClientID() {
		return clientID;
	}

	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	public String getDefaultLanguageID() {
		return defaultLanguageID;
	}

	public void setDefaultLanguageID(String defaultLanguageID) {
		this.defaultLanguageID = defaultLanguageID;
	}

	public String getExamEventCode() {
		return examEventCode;
	}

	public void setExamEventCode(String examEventCode) {
		this.examEventCode = examEventCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsActiveEvent() {
		return isActiveEvent;
	}

	public void setIsActiveEvent(Boolean isActiveEvent) {
		this.isActiveEvent = isActiveEvent;
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

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Boolean getExamEventState() {
		return examEventState;
	}

	public void setExamEventState(Boolean examEventState) {
		this.examEventState = examEventState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ExamEvent [examEventID=" + examEventID + ", clientID=" + clientID + ", defaultLanguageID="
				+ defaultLanguageID + ", examEventCode=" + examEventCode + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", isActiveEvent=" + isActiveEvent + ", createdBy=" + createdBy
				+ ", dateCreated=" + dateCreated + ", modifiedBy=" + modifiedBy + ", dateModified=" + dateModified
				+ ", eventCategory=" + eventCategory + ", eventType=" + eventType + ", examEventState=" + examEventState
				+ "]";
	}
}

