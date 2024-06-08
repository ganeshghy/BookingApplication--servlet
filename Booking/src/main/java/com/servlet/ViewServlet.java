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
import com.classes.dao.ViewDao;


@WebServlet("/ViewRecords")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	ViewDao viewrecord = new ViewDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Book> b = viewrecord.fetchBookingsFromDatabase();
			 PrintWriter out = response.getWriter();
			 String httpresponse = "<html><table border='1'><tr><th>Book_No</th><th>Book_Name</th><th>Author</th><th>Language</th><th>Price</th><th>Update</th><th>Delete</th></tr>";
		     for(Book books:b) {
//		    	 System.out.println(books.toString());
		    	 httpresponse+="<tr><td>"+books.getBno()+"</td><td>"+books.getBname()+"</td><td>"+books.getAuthor()+"</td><td>"+books.getLanguage()+"</td><td>"+books.getPrice()+"</td>";
		    	 
		    	 httpresponse += "<td><a href='updatePage.html?bno=" + books.getBno() + "&bname=" + books.getBname() + "&author=" + books.getAuthor() + "&lan=" + books.getLanguage() + "&price=" + books.getPrice() + "'>Update</a></td>";
		   
		    	 httpresponse += "<td><a href='DeleteRecord?bno=" + books.getBno() + "' onclick='return confirm(\"Are you sure you want to delete this record?\");'>Delete</a></td>";

		    	 
//		    	 System.out.println(httpresponse);
		     }
		     httpresponse+="</table></html>";
			 out.println(httpresponse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
