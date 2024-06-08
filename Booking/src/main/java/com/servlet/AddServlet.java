package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.dao.AddDao;


@WebServlet("/insert")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AddDao ad = new AddDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  bookNo = Integer.parseInt(request.getParameter("bno"));
		String bookName = request.getParameter("bname");
		String author = request.getParameter("author");
		String language = request.getParameter("lan");
		int price =  Integer.parseInt(request.getParameter("price"));
		
		String result = ad.insertRecord(bookNo, bookName, author, language, price);
		
		
		PrintWriter out = response.getWriter();
		if(result.equalsIgnoreCase("success")) {
			RequestDispatcher rd = request.getRequestDispatcher("main.html");
			rd.include(request, response);
		}
		else {
			out.print("Already, the book no is exist!");
			RequestDispatcher rd = request.getRequestDispatcher("main.html");
			rd.include(request, response);
		}
	}

}
