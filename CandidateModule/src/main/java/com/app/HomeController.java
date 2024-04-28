package com.app;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Candidate;
import com.app.entities.Language;
import com.app.entities.Skill;


@RestController
public class HomeController {
	
	@GetMapping("/submit")
	public String save(@RequestParam int cid,
			@RequestParam String name,
			@RequestParam String uname,
			@RequestParam String pass,
			@RequestParam String desc,
			@RequestParam String standard,
			@RequestParam String gender
			) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Candidate.class).addAnnotatedClass(Skill.class).addAnnotatedClass(Language.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
//		String[] skillsArr = skills.split(",");
//		String[] langsArr = langs.split(",");
//		
//		
//		
//		for(int i=0; i<skillsArr.length; i++) { 
//			System.out.println(skillsArr[i]+" ");
//		}
//		for(int i=0; i<langsArr.length; i++) { 
//			System.out.println(langsArr[i]+" ");
//		}
//		Candidate c = new Candidate(cid, name, uname, pass, desc, gender,standard);
////		Skill s = new Skill("personal", c);
////		Language l = new Language("java",c);
//		
//		List<Skill> slist = new ArrayList<>();
//		List<Language> llist = new ArrayList<>();
//		
//		c.setSkills(slist);
//		c.setPrefLangs(llist);
//		
////		c.addLanguage(new Language("java",c));
////		c.addSkill(new Skill("Personal",c));
//		Skill s = new Skill("Personal",c);
//		Language l = new Language("java",c);
//		c.getSkills().add(s);
//		c.getPrefLangs().add(l);
//		
		Candidate c = new Candidate(cid, name, uname, pass, desc, gender, standard);
		Language l = new Language(1, "Java", 1);
		Skill s = new Skill(1, "Cricket",1);
		Transaction tx = session.beginTransaction();
			session.save(c);
			session.save(s);
			session.save(l);
		tx.commit();
		return "Hello world";
	}
}
