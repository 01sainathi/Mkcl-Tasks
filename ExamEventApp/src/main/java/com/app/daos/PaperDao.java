package com.app.daos;

import java.util.List;

import com.app.models.ExamEvent;
import com.app.models.ExamEventPaperDetails;
import com.app.models.Paper;
import com.app.models.ScheduleMaster;
import com.app.models.SchedulePaperAssociation;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class PaperDao {
	
	private ISql icrud = DALHelper.getIsql();

	public List<Paper> getAllPapers() throws DALException {
		
		List<Paper> list = icrud.findAll(Paper.class);
		return list;
	}

	public List<Paper> getSomePapers(Long eeId) throws DALException {
		// TODO Auto-generated method stub
		String query = "select p from "+Paper.class.getName()+" p where p.paperID in (select eepd.fkPaperID from "
		+ExamEventPaperDetails.class.getName()+" eepd where eepd.examEventID="+eeId+")";
		return icrud.executeQuery(query);
	}

	public List<Object> getScheduledPapers() throws DALException {
		// TODO Auto-generated method stub
		
		List<Object> result = null;
		String query = "SELECT e.name,p.name,s.scheduleStart,s.scheduleEnd FROM "+ExamEvent.class.getName()+" e,"+ScheduleMaster.class.getName()+" s,"+Paper.class.getName()+" p,"+SchedulePaperAssociation.class.getName() +" sm WHERE  e.examEventID=sm.fkExamEventID AND s.scheduleID=sm.fkScheduleID AND p.paperID=sm.fkPaperID";
		result = icrud.executeQuery(query);
		return result;
	}

}
