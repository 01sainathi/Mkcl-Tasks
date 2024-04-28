package com.app.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.app.models.ExamEventPaperDetails;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ExamEventPaperDetailsDao {
	
	private ISql icrud = DALHelper.getIsql();
	public String save(List<ExamEventPaperDetails> listOfPapers) throws DALException {
		icrud.saveCollection(listOfPapers);
		
		return null;
	}
	
	public String update(ExamEventPaperDetails exam) throws DALException {
		
		String query = "SELECT eepd.examEventPaperID FROM "+ExamEventPaperDetails.class.getName() +" eepd where eepd.examEventID="+exam.getExamEventID()+" and eepd.fkPaperID="+exam.getFkPaperID();
		Long id = (Long)icrud.executeQuery(query).get(0);
		exam.setExamEventPaperID(id);
		icrud.update(exam);
		return "Updated Successfully";
	}
	
	public String deleteByExamEventID(Map<String, Long> criteria) throws DALException {
		
		icrud.deleteBy(ExamEventPaperDetails.class, criteria);
		
		return "Successfully deleted";
	}

	
	
	 public String deleteByExamEventIDAndPId(Long pId, long eeId) throws
	  DALException {
		  
		  Map<String, Long> criteria = new HashMap<>();
		  criteria.put("examEventID", eeId);
		  criteria.put("fkPaperID", pId);
		  
		  icrud.deleteBy(ExamEventPaperDetails.class, criteria);
		  
		  return "Success";
	  }
	
}
