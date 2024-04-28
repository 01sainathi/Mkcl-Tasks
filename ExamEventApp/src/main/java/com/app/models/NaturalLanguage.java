package com.app.models;

import java.io.Serializable;

public class NaturalLanguage implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String languageName;
	private String nativeName;
	private String isoCode;
	public NaturalLanguage() {
		super();
	}
	public NaturalLanguage(String id, String languageName, String nativeName, String isoCode) {
		super();
		this.id = id;
		this.languageName = languageName;
		this.nativeName = nativeName;
		this.isoCode = isoCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "NaturalLanguage [id=" + id + ", languageName=" + languageName + ", nativeName=" + nativeName
				+ ", isoCode=" + isoCode + "]";
	}
	
	
}

