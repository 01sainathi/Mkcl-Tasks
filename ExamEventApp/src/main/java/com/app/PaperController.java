package com.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.ExamEvent;
import com.app.models.Paper;
import com.app.models.SchedulePaperAssociation;
import com.app.service.PaperService;
import com.app.service.SchedulePaperAssociationService;

@RestController
public class PaperController {
	
	PaperService pserv = new PaperService();
	SchedulePaperAssociationService spa = new SchedulePaperAssociationService();
	
	@GetMapping("/papers")
	public String getAll() {
		
		List<Paper> list = pserv.getAllPapers();
		return list.toString();
	}
	@GetMapping("/papers/some")
	public String getSome(HttpServletRequest req) {
		
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		HttpSession session = req.getSession();
		Long eeId = ((ExamEvent)session.getAttribute("examEvent")).getExamEventID();
		List<Paper> list = pserv.getSomePapers(eeId);
		return list.toString();
	}
	
	@GetMapping("/papers/some/{eeId}")
	public String getSome(@PathVariable long eeId) {
		
		List<Paper> list = pserv.getSomePapers(eeId);
		return list.toString();
	}
	
	@GetMapping("/papers/notScheduled/{eeId_and_sid}")
	public String getNotScheduled(@PathVariable String eeId_and_sid) {
		
		String arr[] = eeId_and_sid.split(",");
		long eeId = Long.parseLong(arr[0]);
		long sid = Long.parseLong(arr[1]);
		
		//Fetching the scheduled papers having eeId and pid
		List<SchedulePaperAssociation> scheduledPapers = spa.getScheduledPapers(eeId, sid);
		
		//adding scheduled paperIds in this set
		Set<Long> scheduledPaperIds = new HashSet<>();
		for(int i=0; i<scheduledPapers.size(); i++) {
			scheduledPaperIds.add(scheduledPapers.get(i).getFkPaperID());
		}
		
		//Getting all papers for the event having eeId
		List<Paper> papers = pserv.getSomePapers(eeId);
		
		List<Paper> notScheduled = new ArrayList<>();
		for(int i=0; i<papers.size(); i++) {
			if(scheduledPaperIds.contains(papers.get(i).getPaperID())) {
				
			}
			else {
				notScheduled.add(papers.get(i));
			}
		}
		return notScheduled.toString();
	}
}
