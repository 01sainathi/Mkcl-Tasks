package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.SchedulePaperAssociationService;

@Controller
@RequestMapping("/SchedulePaperAssociation")
public class SchedulePaperAssociationController {
	
	SchedulePaperAssociationService spaServ = new SchedulePaperAssociationService();
	@GetMapping("/save")
	public String save(@RequestParam String event,
			@RequestParam String date,
			@RequestParam String paper) {
		
		long eeId = Long.parseLong(event);
		long sid = Long.parseLong(date);
		long pid = Long.parseLong(paper);
		
		spaServ.save(eeId, sid, pid);
		return "/ScheduleTest";
	}
	
	
}
