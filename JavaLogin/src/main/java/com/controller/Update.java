package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Emp;
import com.dao.Usersql;

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Emp e = new Emp();
		Usersql usql=new Usersql();
		int result=0;
		String[] data=null;
		HttpSession session=request.getSession();
		e.setName(request.getParameter("name"));
		e.setEmail(request.getParameter("email"));
		e.setAddress(request.getParameter("address"));
		e.setGender(request.getParameter("gender"));
		e.setPass(request.getParameter("pass"));
		e.setUname(request.getParameter("uname"));
		
		try {
			result=usql.updateData(e);
			
			if(result!=0)
			{
				data=usql.singleView(e);
				e.setUname(data[0]);
				e.setName(data[1]);
				e.setEmail(data[2]);
				e.setAddress(data[3]);
				e.setGender(data[4]);
				e.setPass(data[5]);
				session = request.getSession();
				session.setAttribute("uname", e.getUname());
				session.setAttribute("name", e.getName());
				session.setAttribute("email", e.getEmail());
				session.setAttribute("address", e.getAddress());
				session.setAttribute("gender", e.getGender());
				session.setAttribute("pass", e.getPass());
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			}
			else {
				PrintWriter out=response.getWriter();
				out.println("Update Failed");
			}
		}
		catch(SQLException|ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}

}
