package com.app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.NaturalLangService;

@RestController
public class NaturalLangController {
	
	NaturalLangService nlserv = new NaturalLangService();
	@GetMapping("/langs")
	public String getAll() {
		
		List<String> ans = nlserv.getAllLangs();
		return ans.toString();
	}
}
