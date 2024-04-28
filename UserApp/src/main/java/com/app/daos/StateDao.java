package com.app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.models.State;
import com.app.models.User;
import com.app.utils.DbUtil;

public class StateDao implements AutoCloseable{
	
	Connection con;
	PreparedStatement selectStmt;
	PreparedStatement getStateId;
	PreparedStatement getStateName;
	
	public StateDao() throws SQLException {
		con = DbUtil.getConnection();
		
		String query = "select id, name from states";
		selectStmt = con.prepareStatement(query);
		
		query = "select id from states where name=?";
		getStateId = con.prepareStatement(query);
		
		query = "select name from states where id=?";
		getStateName = con.prepareStatement(query);
	}
	
	public List<State> findAll() throws SQLException{
		
		List<State> list = new ArrayList<>();
		
		ResultSet rs = selectStmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			State s = new State(id,name);
			list.add(s);
		}
		return list;
	}
	
	public int getStateId(String state) throws SQLException {
		
		getStateId.setString(1, state);
		ResultSet rs = getStateId.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("id");
			return id;
		}
		return 0;
	}
	
	public String getName(int id) throws SQLException {
		
		getStateName.setInt(1, id);
		ResultSet rs = getStateName.executeQuery();
		String name = "";
		if(rs.next()) {
			name = rs.getString("name");
		}
		return name;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
