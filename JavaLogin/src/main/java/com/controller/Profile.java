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

public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usersql usql = new Usersql();
		Emp e = new Emp();
		String[] data = null;
		HttpSession session = request.getSession();

		e.setUname((String) session.getAttribute("uname"));
		e.setPass((String) session.getAttribute("password"));

		try {
			data = usql.singleView(e);
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
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

}
