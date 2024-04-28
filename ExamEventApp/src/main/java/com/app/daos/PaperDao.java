package com.app.daos;

import java.util.List;

import com.app.models.ExamEventPaperDetails;
import com.app.models.Paper;

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

}
