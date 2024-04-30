package com.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.app.models.ExamEvent;
import com.app.models.ExamEventPaperDetails;
import com.app.models.Paper;
import com.app.service.ExamEventPaperDetailsServ;
import com.app.service.PaperService;

@Controller
@RequestMapping("/ExamEventPaperDetails")
public class ExamEventPaperDetailsController {
	
	ExamEventPaperDetailsServ eServ = new ExamEventPaperDetailsServ();
	PaperService pServ = new PaperService();
	
	@PostMapping("/save")
	@ResponseBody
	public String save(@RequestBody String list, HttpServletRequest req) {
		
		if(list.length()>2) {
			list = list.substring(2);
		}
		else {
			list = "";
		}
		
		HttpSession session = req.getSession();
		
		//only newly added will be there in paperIds 
		session.setAttribute("paperIds", list);
		
		//Extracting examEventId from session
		long id = ((ExamEvent)session.getAttribute("examEvent")).getExamEventID();
		
		//saving the papers in EEPD
		String resp = eServ.save(list, id);
		
		//Storing the updated paper list in session
		List<Paper> papers = pServ.getSomePapers(id);
		
		session.removeAttribute("papers");
		session.setAttribute("papers", papers);
		
		//called by ajax request this is used to alert in the browser
		return "Success";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam String papers,
			@RequestParam String examType,
			@RequestParam String attempts,
			@RequestParam String iq,
			@RequestParam String is,
			@RequestParam String or,
			@RequestParam String pn,
			@RequestParam String sq,
			@RequestParam String ao,
			@RequestParam String sr,
			@RequestParam String sn,
			HttpServletRequest req
			) 
	{
		HttpSession session = req.getSession();
		Long eeId =((ExamEvent)session.getAttribute("examEvent")).getExamEventID();
		ExamEventPaperDetails exam = new ExamEventPaperDetails(
				eeId, 
				Long.parseLong(papers),
				Integer.parseInt(attempts),
				Boolean.valueOf(or),
				"Sainath",
				new Date(),
				Boolean.valueOf(iq),
				Boolean.valueOf(is),
				Boolean.valueOf(sq),
				Boolean.valueOf(ao),
				Boolean.valueOf(sn),
				Boolean.valueOf(pn)
				);
		
		
		eServ.update(exam);
		return "/PaperConfig";
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody String list, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Long eeId = ((ExamEvent)session.getAttribute("examEvent")).getExamEventID();
		System.out.println("----------------------"+list);
		eServ.deleteByEEIdPId(list, eeId);
		return "Success check db";
	}
	
}
