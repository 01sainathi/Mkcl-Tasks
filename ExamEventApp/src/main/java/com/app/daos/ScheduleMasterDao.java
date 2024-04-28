package com.app.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.models.ScheduleMaster;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ScheduleMasterDao {
	
	private ISql icrud = DALHelper.getIsql();
	public String save(ScheduleMaster sm) throws DALException {
		// TODO Auto-generated method stub
		
		icrud.save(sm);
		return "Successfully Added";
	}
	
	public List<ScheduleMaster> getAll() throws DALException{
		
		return icrud.findAll(ScheduleMaster.class);
	}

	public String delete(Long id) throws DALException {
		
		HashMap<String, Long> criteria = new HashMap<>();
		criteria.put("scheduleID", id);
		icrud.deleteBy(ScheduleMaster.class, criteria);

		return "Successfully Deleted";
	}

	public ScheduleMaster getById(Map<String, Long> criteria) throws DALException{
		// TODO Auto-generated method stub
		return icrud.findBy(ScheduleMaster.class, criteria).get(0);
		
	}

	public String update(ScheduleMaster sm) throws DALException {
		// TODO Auto-generated method stub
		icrud.update(sm);
		
		return "Successfully updated";
	}

	public List<ScheduleMaster> getByEEId(Map<String, Long> criteria) throws DALException {
		// TODO Auto-generated method stub
		return icrud.findBy(ScheduleMaster.class, criteria);
	}

}
