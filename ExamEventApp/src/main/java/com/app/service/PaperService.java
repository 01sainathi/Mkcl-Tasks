package com.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.daos.PaperDao;
import com.app.dto.ScheduledTestDTO;
import com.app.models.Paper;

import mkcl.os.model.dal.DALException;

public class PaperService {
	
	PaperDao pDao = new PaperDao();
	
	public List<Paper> getAllPapers(){
		
		try {
			List<Paper> list = pDao.getAllPapers();
			return list;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Paper> getSomePapers(Long eeId) {
		
		try {
			List<Paper> list = pDao.getSomePapers(eeId);
			return list;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ScheduledTestDTO> getScheduledPapers(){
		
		try {
			List<Object> list = pDao.getScheduledPapers();
			
			List<ScheduledTestDTO> papers = new ArrayList<>();
			
			for(int i=0; i<list.size(); i++) {
				ScheduledTestDTO obj = new ScheduledTestDTO();
				Object[] rows = (Object[])list.get(i);
				obj.setEname((String)rows[0]);
				obj.setPname((String)rows[1]);
				obj.setSdate((Date)rows[2]);
				obj.setEdate((Date)rows[3]);
				
				papers.add(obj);
			}
			return papers;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
