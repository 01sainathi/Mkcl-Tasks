package com.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.daos.CityDao;
import com.app.daos.StateDao;
import com.app.daos.UserDao;
import com.app.models.City;
import com.app.models.State;
import com.app.models.User;

@RestController
public class UserController {
	
	@GetMapping("/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("index");
	}
	
	@GetMapping("/submit")
	public RedirectView save(HttpServletRequest req) throws SQLException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String state = req.getParameter("state");
		String city = req.getParameter("city");
		
		StateDao sDao = new StateDao();
		CityDao cDao = new CityDao();
		int sid = sDao.getStateId(state);
		int cid = cDao.getCityId(city);
		
		User u = new User(id, name, email, sid, cid);
		
		UserDao uDao = new UserDao();
		System.out.println(uDao.save(u));
		
		RedirectView rv = new RedirectView("http://localhost:8080/UserApp/index.jsp");
		return rv;
	}
	
	
	@GetMapping("/getCities/{state}")
	public String getCities(@PathVariable String state) {
		List<City> list = null;
		try(CityDao cDao = new CityDao()){
			list = cDao.findByState(state);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.toString();
	}
	
	@GetMapping("/getStates")
	public String getStates() {
		List<State> list = null;
		try(StateDao uDao = new StateDao()){
			list = uDao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list.toString();
	}
}
