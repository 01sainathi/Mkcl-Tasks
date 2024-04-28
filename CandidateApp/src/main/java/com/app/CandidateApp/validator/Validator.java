package com.app.CandidateApp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static boolean isfNameValid(String f) {
		
		if(f.length()<5 && f.length()>15) {
			return false;
		}
//		String regex = "^[A-Za-z]\\\\w{5, 29}$";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(f);
		
		
		return true;
	}
	
	public static boolean islNameValid(String l) {
		
		if(l.length()<5 && l.length()>15) {
			return false;
		}
//		String regex = "^[A-Za-z]\\\\w{5, 29}$";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(l);
		
		
		return true;
	}
	
	public static boolean isEmailValid(String e) {
		
		String regex = "^(.+)@(.+)$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(e);
		
		return m.matches();
	}
	
	public static boolean isMobValid(String m) {
		
		String regex = "^\\d{10}$";
		Pattern p = Pattern.compile(regex);
		Matcher mat = p.matcher(m);
		
		return mat.matches();
	}
}
