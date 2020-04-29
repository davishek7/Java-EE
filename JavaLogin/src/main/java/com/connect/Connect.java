package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public static Connection dbCon()
	{
		Connection con=null;
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/Avishek";
		String user="postgres";
		String pass="1234";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
