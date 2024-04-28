package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.daos.PaperDao;
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
}
