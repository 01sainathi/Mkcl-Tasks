package com.app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.models.Candidate;
import com.app.utils.DbUtil;

public class CandidateDao implements AutoCloseable{
	
	Connection con;
	PreparedStatement insertStmt;
	PreparedStatement selectStmt;
	PreparedStatement deleteStmt;
	PreparedStatement updateStmt;
	PreparedStatement findById;
	public CandidateDao() throws SQLException{
		
		con = DbUtil.getConnection();
		
		String query = "INSERT INTO candidates VALUES(?,?,?,?,?)";
		insertStmt = con.prepareStatement(query);
		
		query = "select * from candidates";
		selectStmt = con.prepareStatement(query);
		
		query = "delete from candidates where id=?";
		deleteStmt = con.prepareStatement(query);
		
		query = "update candidates set first_name=?, last_name=?, email=?, phone_no=? where id=?";
		updateStmt = con.prepareStatement(query);
		
		query = "select * from candidates where id=?";
		findById = con.prepareStatement(query);
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(deleteStmt != null) {
			deleteStmt.close();
		}
		if(selectStmt != null) {
			selectStmt.close();
		}
		if(insertStmt != null) {
			insertStmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	public int save(Candidate c) throws SQLException {
		
		insertStmt.setInt(1, c.getId());
		insertStmt.setString(2, c.getfName());
		insertStmt.setString(3, c.getlName());
		insertStmt.setString(4, c.getEmail());
		insertStmt.setString(5, c.getMob());
		
		int rows = insertStmt.executeUpdate();
		return rows;
	}
	
	public List<Candidate> findAll() throws SQLException{
		
		ResultSet rs = selectStmt.executeQuery();
		
		List<Candidate> list = new ArrayList<>();
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String fName = rs.getString("first_name");
			String lName = rs.getString("last_name");
			String email = rs.getString("email");
			String mob = rs.getString("phone_no");
			
			Candidate c = new Candidate(id, fName, lName, email, mob);
			list.add(c);
		}
		
		return list;
	}
	
	public int delete(int id) throws SQLException {
		
		deleteStmt.setInt(1, id);
		int rows = deleteStmt.executeUpdate();
		return rows;
	}
	
	public int update(Candidate c) throws SQLException {
		
		updateStmt.setString(1, c.getfName());
		updateStmt.setString(2, c.getlName());
		updateStmt.setString(3, c.getEmail());
		updateStmt.setString(4, c.getMob());
		updateStmt.setInt(5, c.getId());
		
		int rows = updateStmt.executeUpdate();
		return rows;
	}
	
	public Candidate findById(int id) throws SQLException {
		
		findById.setInt(1, id);
		ResultSet rs = findById.executeQuery();
		Candidate c=null;
		if(rs.next()) {
			int i = rs.getInt("id");
			String fName = rs.getString("first_name");
			String lName = rs.getString("last_name");
			String email = rs.getString("email");
			String mob = rs.getString("phone_no");
			
			c = new Candidate(i, fName, lName, email, mob);
		}
		return c;
	}
}
