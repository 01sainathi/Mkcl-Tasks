package com.app;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.models.ExamEvent;
import com.app.models.Paper;
import com.app.service.HomeService;
import com.app.service.PaperService;

import mkcl.os.model.dal.DALException;

@Controller
public class HomeController {
	
	private HomeService hServ = new HomeService();
	private PaperService pServ = new PaperService();
	
	@GetMapping("/submit")
	public String dummy(@RequestParam String name,
			@RequestParam String code,
			@RequestParam String language,
			@RequestParam String start_date,
			@RequestParam String end_date) throws DALException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date sDate=null;
		Date eDate=null;
		try {
			sDate = sdf.parse(start_date);
			eDate = sdf.parse(end_date);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ExamEvent e = new ExamEvent(165,language, code, name, sDate, eDate,"Sainath",sDate);
		hServ.save(e);
		
		return "index";
	}
	
	@GetMapping("/proceed/{id}")
	public String proceed(@PathVariable int id, HttpServletRequest request) {
		
		ExamEvent e = hServ.findById(id);
		HttpSession session =request.getSession();
		
		List<Paper> papers = pServ.getSomePapers(e.getExamEventID());
		
		session.setAttribute("examEvent", e);
		session.setAttribute("papers", papers);
		return "AddPaper";
	}
	
	@GetMapping("/getSession")
	@ResponseBody
	public String getSession(HttpServletRequest req) {
		
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println("-----------------"+attribute+" : "+req.getSession().getAttribute(attribute));
		}
		return req.getSession().toString();
	}
	
	@GetMapping("/activate")
	@ResponseBody
	public String activateEE(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		ExamEvent e = (ExamEvent)session.getAttribute("examEvent");
		
		return hServ.activate(e);
	}
}
