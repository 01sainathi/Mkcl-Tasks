package com.app.daos;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.models.ExamEvent;
import com.app.service.HomeService;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class HomeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeService.class);
	private ISql icrud = DALHelper.getIsql();
	
	public String save(ExamEvent e) {
		try {
			icrud.save(e);
			return "success";
		} catch (DALException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "error";
	}
	
	public List<ExamEvent> findAll() throws DALException{
		
		List<ExamEvent> list = icrud.findAll(ExamEvent.class);
		
		return list;
	}

	public ExamEvent findById(Map<String, Integer> criteria) throws DALException {
		// TODO Auto-generated method stub
		
		List<ExamEvent> e = icrud.findBy(ExamEvent.class, criteria);
		return e.get(0);
	}

	public String activate(ExamEvent e) throws DALException {
		// TODO Auto-generated method stub
		icrud.update(e);
		
		return "activated";
	}
}
