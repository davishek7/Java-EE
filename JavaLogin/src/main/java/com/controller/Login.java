package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Emp;
import com.dao.Usersql;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Emp e = new Emp();
		 Usersql usql=new Usersql();
		 String[] data=null;
		 HttpSession session=request.getSession();
		 e.setUname(request.getParameter("uname"));
		 e.setPass(request.getParameter("pass"));
		 
		 try
		 {
		 if(usql.userLogin(e))
		 {
			 data=usql.singleView(e);
			 e.setName(data[1]);
			 session.setAttribute("uname",e.getUname());
			 session.setAttribute("name", e.getName());
			 session.setAttribute("password", e.getPass());
			 RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			 rd.forward(request, response);
		 }
		 else {
			 response.sendRedirect("login.jsp");
			 session.setAttribute("ErrorMessage","Login Failed");
		 }
	}catch(SQLException|ClassNotFoundException ex)
		 {
			ex.printStackTrace();
		 }
		 }

}
