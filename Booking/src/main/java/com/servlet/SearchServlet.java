package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.dao.Book;
import com.classes.dao.SearchDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out = response.getWriter();
	SearchDao s = new SearchDao();
	int searchId = Integer.parseInt(request.getParameter("bno"));
	List<Book> book = s.fetchSingleRecord(searchId);
	
	if(book == null) {
		out.println("searchId not exists!");
	}
	else {
		String resultSet = "<html><table border='1px'><tr><th>BookNo</th><th>BookName</th><th>Author</th><th>Language</th><th>Price</th></tr>";
		for(Book books : book) {
			resultSet+="<tr><td>"+books.getBno()+"</td><td>"+books.getBname()+"</td><td>"+books.getAuthor()+"</td><td>"+books.getLanguage()+"</td><td>"+books.getPrice()+"</td></tr>";
		}
		resultSet+="</table></html>";
		out.println(resultSet);
	}
		

	}
	

}
