package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.dao.Usersql;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usersql usql = new Usersql();
		Emp e = new Emp();
		int result = 0;

		e.setUname(request.getParameter("uname"));
		e.setName(request.getParameter("name"));
		e.setEmail(request.getParameter("email"));
		e.setAddress(request.getParameter("address"));
		e.setGender(request.getParameter("gender"));
		e.setPass(request.getParameter("pass"));

		try {
			if (usql.checkUser(e)) {
				result = usql.insertData(e);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (result != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}
