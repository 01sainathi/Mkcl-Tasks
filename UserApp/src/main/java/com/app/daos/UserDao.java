package com.app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.models.User;
import com.app.utils.DbUtil;

public class UserDao {
	
	Connection con;
	PreparedStatement insertStmt;
	PreparedStatement findAll;
	
	public UserDao() throws SQLException {
		con = DbUtil.getConnection();
		
		String query = "insert into users values(?,?,?,?,?)";
		insertStmt = con.prepareStatement(query);
		
		query = "select * from users";
		findAll = con.prepareStatement(query);
	}
	
	public int save(User u) throws SQLException {
		
		insertStmt.setInt(1, u.getId());
		insertStmt.setString(2, u.getName());
		insertStmt.setString(3, u.getEmail());
		insertStmt.setInt(4, u.getSid());
		insertStmt.setInt(5, u.getCid());
		
		int rows = insertStmt.executeUpdate();
		
		return rows;
	}
	
	public List<User> findAll() throws SQLException{
		
		ResultSet rs = findAll.executeQuery();	
		List<User> list = new ArrayList<>();
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			int sid = rs.getInt("sid");
			int cid=  rs.getInt("cid");
			
			User u = new User(id, name, email, sid, cid);
			list.add(u);
		}
		
		return list;
	}
}
