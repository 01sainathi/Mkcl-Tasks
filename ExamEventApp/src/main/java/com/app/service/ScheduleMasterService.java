package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.daos.ScheduleMasterDao;
import com.app.models.ScheduleMaster;

import mkcl.os.model.dal.DALException;

public class ScheduleMasterService {
	
	ScheduleMasterDao smDao = new ScheduleMasterDao();
	public String save(ScheduleMaster sm) {
		// TODO Auto-generated method stub
		
		try {
			return smDao.save(sm);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something Went Wrong";
	}
	
	public List<ScheduleMaster> getAll(){
		
		try {
			return smDao.getAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String delete(Long id) {
		// TODO Auto-generated method stub
		
		try {
			
			return smDao.delete(id);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something went wrong";
	}

	public ScheduleMaster getById(Long id) {
		// TODO Auto-generated method stub
		
		Map<String, Long> criteria = new HashMap<>();
		criteria.put("scheduleID", id);
		ScheduleMaster sm = null;
		try {
			sm = smDao.getById(criteria);
			return sm;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sm;
	}

	public String update(ScheduleMaster sm) {
		// TODO Auto-generated method stub
		try {
			return smDao.update(sm);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something went wrong";
	}

	public List<ScheduleMaster> getSome(Long eeId) {
		// TODO Auto-generated method stub
		
		Map<String, Long> criteria = new HashMap<>();
		criteria.put("fkExamEventID", eeId);
		try {
			return smDao.getByEEId(criteria);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
