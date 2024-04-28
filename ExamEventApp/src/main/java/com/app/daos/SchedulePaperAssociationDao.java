package com.app.daos;

import java.util.List;
import java.util.Map;

import com.app.models.SchedulePaperAssociation;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class SchedulePaperAssociationDao {
	
	private ISql icrud = DALHelper.getIsql();
	public String save(SchedulePaperAssociation spa) throws DALException {
		
		icrud.save(spa);
		return "Successfully Scheduled";
	}
	public List<SchedulePaperAssociation> getScheduledPapers(Map<String, Long> criteria) throws DALException {
		// TODO Auto-generated method stub
		
		return icrud.findBy(SchedulePaperAssociation.class, criteria);
	}

}
