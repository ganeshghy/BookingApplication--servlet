package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.dao.signUpDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	signUpDao sign = new signUpDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username"); 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String result = sign.insertRecord(userName, email, password);
		
		PrintWriter out = response.getWriter();
		if(result.equalsIgnoreCase("success")) {
			out.println("Successfully created account..");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		else {
			out.println("can't create account");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);		
		}
	}

}
