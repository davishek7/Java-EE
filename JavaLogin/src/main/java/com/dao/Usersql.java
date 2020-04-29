package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Emp;
import com.connect.Connect;

public class Usersql {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int insertData(Emp e) throws SQLException {
		int result = 0;
		String insertData = "insert into emp values(?,?,?,?,?,?)";
		con = Connect.dbCon();

		ps = con.prepareStatement(insertData);
		ps.setString(1, e.getUname());
		ps.setString(2, e.getName());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getAddress());
		ps.setString(5, e.getGender());
		ps.setString(6, e.getPass());

		result = ps.executeUpdate();

		con.close();
		return result;
	}

	public boolean userLogin(Emp e) throws SQLException {
		String checkData = "Select * from emp where username=? and pass=?";
		con = Connect.dbCon();

		ps = con.prepareStatement(checkData);
		ps.setString(1, e.getUname());
		ps.setString(2, e.getPass());

		rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean checkUser(Emp e) throws SQLException {
		String checkData = "Select * from emp where username=? and email=?";
		con = Connect.dbCon();

		ps = con.prepareStatement(checkData);
		ps.setString(1, e.getUname());
		ps.setString(2, e.getEmail());

		rs = ps.executeQuery();

		if (!rs.next()) {
			return true;
		}
		return false;
	}
	public String[] singleView(Emp e) throws ClassNotFoundException, SQLException {
		String data[] = null;
		int count = 0;

		con = Connect.dbCon();

		String sql = "select * from emp where username=? and pass=?";

		ps = con.prepareStatement(sql);
		ps.setString(1, e.getUname());
		ps.setString(2, e.getPass());

		rs = ps.executeQuery();
		count = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			data = new String[count];
			for (int i = 0; i < count; i++) {
				data[i] = rs.getString(i + 1);
			}
		}
		con.close();
		return data;
	}
	public int updateData(Emp e) throws SQLException {
		int result = 0;
		String updateData = "update emp set name=?,email=?,address=?,pass=? where username=?";
		con = Connect.dbCon();

		ps = con.prepareStatement(updateData);
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmail());
		ps.setString(3, e.getAddress());
		ps.setString(4, e.getPass());
		ps.setString(5, e.getUname());

		result = ps.executeUpdate();

		con.close();
		return result;
	}

}
