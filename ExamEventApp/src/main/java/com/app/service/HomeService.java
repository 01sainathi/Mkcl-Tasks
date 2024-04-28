package com.app.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.daos.HomeDao;
import com.app.daos.NaturalLanguageDao;
import com.app.models.ExamEvent;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;


public class HomeService {
	
	private NaturalLanguageDao nDao = new NaturalLanguageDao();
	private HomeDao hDao = new HomeDao();
	
	public String save(ExamEvent e) throws DALException {
		
		System.out.println("In Homeservice save");
		System.out.println(e.getDefaultLanguageID());
		String id;
		try {
			id = nDao.getByName(e.getDefaultLanguageID()).getId();
			e.setDefaultLanguageID(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		hDao.save(e);
		
		return "Check DB";
		
	}
	
	public List<ExamEvent> findAll(){
		try {
			return hDao.findAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ExamEvent findById(int id) {
		Map<String, Integer> criteria = new HashMap<>();
		criteria.put("examEventID",id);
		try {
			ExamEvent e = hDao.findById(criteria);
			return e;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String activate(ExamEvent e) {
		// TODO Auto-generated method stub
		e.setIsActiveEvent(true);
		try {
			return hDao.activate(e);
		} catch (DALException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "something went wrong";
	}
}
