package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.daos.ExamEventPaperDetailsDao;
import com.app.models.ExamEventPaperDetails;
import com.app.models.Paper;

import mkcl.os.model.dal.DALException;

public class ExamEventPaperDetailsServ {
	
	ExamEventPaperDetailsDao eDao = new ExamEventPaperDetailsDao();
	
	public String save(String list, long examEventId) {
		
		List<ExamEventPaperDetails> listOfPapers = new ArrayList<>();
		
		String arr[];
		
		if(list.length()>0) {
			arr = list.split(",");
		}
		else {
			arr = new String[0];
		}

		//adding papers into listOfPapers(ExamEventPaperDetails)
		for(int i=0; i<arr.length; i++) {
			long paperId = Long.parseLong(arr[i]);
			ExamEventPaperDetails obj = new ExamEventPaperDetails(examEventId,paperId);
			listOfPapers.add(obj);
		}
		
		try {
			eDao.save(listOfPapers);
			System.out.println("to save ----------------->"+listOfPapers);
			return "__________Papers successfully added...";
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "____________Something went wrong...";
	}
	
	public String update(ExamEventPaperDetails exam) {
		
		try {
			return eDao.update(exam);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something went wrong";
	}

	public void deleteByEEIdPId(String list, long eeId) {
		
		String arr[] = list.split(",");
		List<Long> pIds = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			pIds.add(Long.parseLong(arr[i]));
		}
		
		for(int i=0; i<pIds.size(); i++) {
			try {
				System.out.println("-------------->"+eDao.deleteByExamEventIDAndPId(pIds.get(i), eeId));
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("To remove--------------------->"+pIds);
	}

	
	
}
