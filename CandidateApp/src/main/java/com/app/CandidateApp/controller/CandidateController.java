package com.app.CandidateApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.CandidateApp.models.Candidate;
import com.app.CandidateApp.services.CandidateService;
import com.app.CandidateApp.sources.DataStore;
import com.app.CandidateApp.validator.Validator;

@Controller
public class CandidateController {
	
	
	@RequestMapping("/submit")
	public String save(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String email = req.getParameter("email");
		String mob = req.getParameter("mob");
		
		if(Validator.isfNameValid(fName) && Validator.islNameValid(lName) && 
				Validator.isEmailValid(email) && Validator.isMobValid(mob)) {
			Candidate c = new Candidate(id, fName, lName, email, mob);
			
			DataStore.list.add(c);
			
			return "redirect:/";
		}
		return "/error";
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id) {
		
		Candidate c = CandidateService.findById(id);
		
		ModelAndView mv = new ModelAndView("edit", "Candidate", c);
		
		return mv;
	}
	
	@RequestMapping("/edit/update")
	public RedirectView update(HttpServletRequest req) {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String email = req.getParameter("email");
		String mob = req.getParameter("mob");
		
		Candidate c = new Candidate(id, fName, lName, email, mob);
		
		CandidateService.update(c);
		
		RedirectView rv = new RedirectView("http://localhost:8080/CandidateApp/");
		
		return rv;
	}
	
	@RequestMapping("/delete/{id}")
	public RedirectView delete(@PathVariable int id) {
		
		CandidateService.delete(id);
		RedirectView m = new RedirectView("http://localhost:8080/CandidateApp/");
		return m;
	}
}
