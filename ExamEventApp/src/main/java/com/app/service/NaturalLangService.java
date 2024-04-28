package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.daos.NaturalLanguageDao;
import com.app.models.NaturalLanguage;

import mkcl.os.model.dal.DALException;

public class NaturalLangService {
	
	NaturalLanguageDao nlDao = new NaturalLanguageDao();
	public List<String> getAllLangs(){
		
		List<NaturalLanguage> list = null;
		try {
			list = nlDao.getAllLangs();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> langs = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			langs.add(list.get(i).getLanguageName());
		}
		return langs;
	}
}
