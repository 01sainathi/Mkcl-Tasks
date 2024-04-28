package com.app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.models.City;
import com.app.utils.DbUtil;

public class CityDao implements AutoCloseable{
	
	Connection con;
	PreparedStatement selectStmt;
	PreparedStatement getCityId;
	PreparedStatement getCityName;
	public CityDao() throws SQLException {
		con = DbUtil.getConnection();
		
		String query = "SELECT * FROM cities WHERE sid = (SELECT id FROM states WHERE NAME=?)"; 
		selectStmt = con.prepareStatement(query);
		
		query = "select id from cities where city_name=?";
		getCityId = con.prepareStatement(query);
		
		query = "select city_name from cities where id=?";
		getCityName = con.prepareStatement(query);
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<City> findByState(String state) throws SQLException{
		
		selectStmt.setString(1, state);
		
		ResultSet rs = selectStmt.executeQuery();
		List<City> list = new ArrayList<>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("city_name");
			int sid = rs.getInt("sid");
			
			City c = new City(id,name,sid);
			list.add(c);
		}
		
		System.out.println(list);
		return list;
	}
	
	public int getCityId(String city) throws SQLException {
		
		getCityId.setString(1, city);
		ResultSet rs = getCityId.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("id");
			return id;
		}
		return 0;
	}
	
	public String getName(int id) throws SQLException {
		
		getCityName.setInt(1, id);
		ResultSet rs = getCityName.executeQuery();
		String name = "";
		if(rs.next()) {
			name = rs.getString("city_name");
		}
		System.out.println(name);
		return name;
	}
	
}
