package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if(session!=null)
		{
			session.removeAttribute("uname");
			session.removeAttribute("name");
			session.invalidate();
			response.sendRedirect("login.jsp");
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		    response.setDateHeader("Expires", 0);
		}
	}

}
