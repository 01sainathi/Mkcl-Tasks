package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.models.ExamEvent;
import com.app.models.ScheduleMaster;
import com.app.service.ScheduleMasterService;

@Controller
@RequestMapping("ScheduleMaster")
public class ScheduleMasterController {
	
	ScheduleMasterService smServ = new ScheduleMasterService();
	@GetMapping("/save")
	public String save(@RequestParam String schedule,
			@RequestParam String noOfPapers,
			@RequestParam String startDate,
			@RequestParam String endDate,
			HttpServletRequest req) 
	{
			SimpleDateFormat sdf=  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date sDate = null;
			Date eDate = null;
			
			int papers = Integer.parseInt(noOfPapers);
			
			String createdBy = "Sainath";
			Date dateCreated = new Date();
			
			HttpSession session = req.getSession();
			long fkExamEventID = ((ExamEvent)session.getAttribute("examEvent")).getExamEventID();
			try {
				sDate = sdf.parse(startDate);
				eDate = sdf.parse(endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ScheduleMaster sm = new ScheduleMaster(sDate, eDate, createdBy, dateCreated, fkExamEventID,schedule,papers);
			smServ.save(sm);
			return "Schedule";
//			return sm.toString();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		smServ.delete(id);
		return "redirect:/Schedule.jsp";
	}
	
	@GetMapping("/edit/{id}")
	@ResponseBody
	public ModelAndView edit(@PathVariable Long id, HttpServletRequest req) {
		ScheduleMaster sm = smServ.getById(id);
		HttpSession session = req.getSession();
		session.setAttribute("sm", sm);
		ModelAndView mv = new ModelAndView("EditSchedule", "ScheMast", sm);
		return mv;
	}
	
	@GetMapping("/update")
	public String update(
			@RequestParam String schedule,
			@RequestParam String noOfPapers,
			@RequestParam String startDate,
			@RequestParam String endDate,
			HttpServletRequest req) 
	{
		SimpleDateFormat sdf=  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date sDate = null;
		Date eDate = null;
		
		int papers = Integer.parseInt(noOfPapers);
		
		String modifiedBy = "Sainath";
		Date dateModified = new Date();
		
		HttpSession session = req.getSession();
		ScheduleMaster sm = (ScheduleMaster)session.getAttribute("sm");
		
		try {
			sDate = sdf.parse(startDate);
			eDate = sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sm.setMaxNumberOfPapers(papers);
		sm.setScheduleStart(sDate);
		sm.setScheduleEnd(eDate);
		sm.setModifiedBy(modifiedBy);
		sm.setDateModified(dateModified);
		sm.setScheduleType(schedule);
		
		smServ.update(sm);
		return "/Schedule";
	}
	
	@GetMapping("/getSome")
	@ResponseBody
	public String getSome(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Long eeId = ((ExamEvent)session.getAttribute("examEvent")).getExamEventID();
		List<ScheduleMaster> schedules = smServ.getSome(eeId);
		return schedules.toString();
	}
	
	@GetMapping("/getSome/{eeId}")
	@ResponseBody
	public String getSome(@PathVariable long eeId,HttpServletRequest req) {
		
		List<ScheduleMaster> schedules = smServ.getSome(eeId);
		return schedules.toString();
	}
}
