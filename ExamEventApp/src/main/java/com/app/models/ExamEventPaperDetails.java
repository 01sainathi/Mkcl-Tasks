package com.app.models;

import java.util.Date;
import java.util.List;

public class ExamEventPaperDetails {

	private long examEventPaperID;
	private long examEventID;
	private Long fkPaperID;

	private int noOfAttempts;	

	private Boolean isRandomOption;
	private String allowAttemptType;

	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private char deleted;

	private boolean isIdenticalItems;
	private boolean isIdenticalItemSequence;

	private boolean isSkipQuestion;
	private boolean isAnswerChange;

	
	private boolean showNotepad;

	private boolean palletNavigation;
	
	public ExamEventPaperDetails(long examEventPaperID, long examEventID, Long fkPaperID, int noOfAttempts,
			Boolean isRandomOption, String allowAttemptType, String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, char deleted, boolean isIdenticalItems, boolean isIdenticalItemSequence,
			boolean isSkipQuestion, boolean isAnswerChange, boolean showNotepad, boolean palletNavigation) {
		super();
		this.examEventPaperID = examEventPaperID;
		this.examEventID = examEventID;
		this.fkPaperID = fkPaperID;
		this.noOfAttempts = noOfAttempts;
		this.isRandomOption = isRandomOption;
		this.allowAttemptType = allowAttemptType;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.deleted = deleted;
		this.isIdenticalItems = isIdenticalItems;
		this.isIdenticalItemSequence = isIdenticalItemSequence;
		this.isSkipQuestion = isSkipQuestion;
		this.isAnswerChange = isAnswerChange;
		this.showNotepad = showNotepad;
		this.palletNavigation = palletNavigation;
	}
	
	
	public ExamEventPaperDetails(long examEventID, Long fkPaperID, int noOfAttempts, Boolean isRandomOption,
			String createdBy, Date dateCreated, boolean isIdenticalItems, boolean isIdenticalItemSequence,
			boolean isSkipQuestion, boolean isAnswerChange, boolean showNotepad, boolean palletNavigation) {
		super();
		this.examEventID = examEventID;
		this.fkPaperID = fkPaperID;
		this.noOfAttempts = noOfAttempts;
		this.isRandomOption = isRandomOption;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.isIdenticalItems = isIdenticalItems;
		this.isIdenticalItemSequence = isIdenticalItemSequence;
		this.isSkipQuestion = isSkipQuestion;
		this.isAnswerChange = isAnswerChange;
		this.showNotepad = showNotepad;
		this.palletNavigation = palletNavigation;
	}


	public ExamEventPaperDetails(long examEventID, Long fkPaperID) {
		super();
		this.examEventID = examEventID;
		this.fkPaperID = fkPaperID;
	}


	public ExamEventPaperDetails() {
		super();
	}
	
	public long getExamEventPaperID() {
		return examEventPaperID;
	}

	public void setExamEventPaperID(long examEventPaperID) {
		this.examEventPaperID = examEventPaperID;
	}

	public long getExamEventID() {
		return examEventID;
	}

	public void setExamEventID(long examEventID) {
		this.examEventID = examEventID;
	}

	public Long getFkPaperID() {
		return fkPaperID;
	}

	public void setFkPaperID(Long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}

	public int getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public Boolean getIsRandomOption() {
		return isRandomOption;
	}

	public void setIsRandomOption(Boolean isRandomOption) {
		this.isRandomOption = isRandomOption;
	}

	public String getAllowAttemptType() {
		return allowAttemptType;
	}

	public void setAllowAttemptType(String allowAttemptType) {
		this.allowAttemptType = allowAttemptType;
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

	public char getDeleted() {
		return deleted;
	}

	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}

	public boolean getIsIdenticalItems() {
		return isIdenticalItems;
	}

	public void setIsIdenticalItems(boolean isIdenticalItems) {
		this.isIdenticalItems = isIdenticalItems;
	}

	public boolean getIsIdenticalItemSequence() {
		return isIdenticalItemSequence;
	}

	public void setIsIdenticalItemSequence(boolean isIdenticalItemSequence) {
		this.isIdenticalItemSequence = isIdenticalItemSequence;
	}

	public boolean getIsSkipQuestion() {
		return isSkipQuestion;
	}

	public void setIsSkipQuestion(boolean isSkipQuestion) {
		this.isSkipQuestion = isSkipQuestion;
	}

	public boolean getIsAnswerChange() {
		return isAnswerChange;
	}

	public void setIsAnswerChange(boolean isAnswerChange) {
		this.isAnswerChange = isAnswerChange;
	}

	public boolean getShowNotepad() {
		return showNotepad;
	}

	public void setShowNotepad(boolean showNotepad) {
		this.showNotepad = showNotepad;
	}

	public boolean getPalletNavigation() {
		return palletNavigation;
	}

	public void setPalletNavigation(boolean palletNavigation) {
		this.palletNavigation = palletNavigation;
	}
	
	@Override
	public String toString() {
		return "ExamEventPaperDetails [examEventPaperID=" + examEventPaperID + ", examEventID=" + examEventID
				+ ", fkPaperID=" + fkPaperID + ", noOfAttempts=" + noOfAttempts + ", isRandomOption=" + isRandomOption
				+ ", allowAttemptType=" + allowAttemptType + ", createdBy=" + createdBy + ", dateCreated=" + dateCreated
				+ ", modifiedBy=" + modifiedBy + ", dateModified=" + dateModified + ", deleted=" + deleted
				+ ", isIdenticalItems=" + isIdenticalItems + ", isIdenticalItemSequence=" + isIdenticalItemSequence
				+ ", isSkipQuestion=" + isSkipQuestion + ", isAnswerChange=" + isAnswerChange + ", showNotepad="
				+ showNotepad + ", palletNavigation=" + palletNavigation + "]";
	}
}

