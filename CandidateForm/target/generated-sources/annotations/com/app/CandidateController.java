package com.app;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.daos.CandidateDao;
import com.app.models.Candidate;

@Controller
public class CandidateController {
	
	@RequestMapping("/submit")
    public String save(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String mob = request.getParameter("mob");
		
		Candidate c = new Candidate(id, fName, lName, email, mob);
		try(CandidateDao cDao = new CandidateDao()){
			System.out.println(cDao.save(c));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index.jsp";
    }
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable int id, HttpServletResponse response) throws SQLException {
		
		try(CandidateDao cDao = new CandidateDao()) {
			System.out.println(cDao.delete(id));
			response.sendRedirect("http://localhost:8080/CandidateForm/index.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id, HttpServletRequest request) {
		
		ModelAndView mv = null;
		try (CandidateDao cDao = new CandidateDao()) {
	        Candidate candidate = cDao.findById(id);
	        System.out.print(candidate.toString());
	        
	        mv = new ModelAndView("/edit.jsp", "Candidate", candidate);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return mv;
	}

	
	@RequestMapping("/edit/update")
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String mob = request.getParameter("mob");
		
		Candidate c = new Candidate(id, fName, lName, email, mob);
		try(CandidateDao cDao = new CandidateDao()){
			System.out.println(cDao.update(c));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:8080/CandidateForm/index.jsp");
	}
}
