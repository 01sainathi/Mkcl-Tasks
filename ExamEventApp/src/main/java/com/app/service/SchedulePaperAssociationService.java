package com.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.daos.SchedulePaperAssociationDao;
import com.app.models.SchedulePaperAssociation;

import mkcl.os.model.dal.DALException;

public class SchedulePaperAssociationService {
	
	SchedulePaperAssociationDao spaDao = new SchedulePaperAssociationDao();
	public String save(long eeId, long sid, long pid) {
		// TODO Auto-generated method stub
		
		SchedulePaperAssociation spa = new SchedulePaperAssociation();
		spa.setFkExamEventID(eeId);
		spa.setFkPaperID(pid);
		spa.setFkScheduleID(sid);
		spa.setCreatedBy("Sainath");
		spa.setDateCreated(new Date());
		try {
			return spaDao.save(spa);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something went wrong";
	}
	public List<SchedulePaperAssociation> getScheduledPapers(long eeId, long sid) {
		Map<String, Long> criteria = new HashMap<>();
		criteria.put("fkExamEventID", eeId);
		criteria.put("fkScheduleID", sid);
		try {
			return spaDao.getScheduledPapers(criteria);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
