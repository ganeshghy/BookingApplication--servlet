package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.dao.DeleteDao;

@WebServlet("/DeleteRecord")


public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    DeleteDao delete = new DeleteDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
            String bno = request.getParameter("bno");
            String result = delete.deleteRecord(bno);
    		
    		PrintWriter out = response.getWriter();
    		if(result.equalsIgnoreCase("success")) {
    			response.sendRedirect(request.getContextPath() + "/ViewRecords");
    		}
    		else {
    			out.println("can't delete record,something wrong");
    			RequestDispatcher rd = request.getRequestDispatcher("main.html");
    			rd.include(request, response);
    		}
    }

       //You can also add the doPost method if needed
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


/*@WebServlet("/DeleteRecord")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeleteDao delete = new DeleteDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  bookNo = Integer.parseInt(request.getParameter("bno"));
  		
  		String result = delete.deleteRecord(bookNo);
  		
  		PrintWriter out = response.getWriter();
  		if(result.equalsIgnoreCase("success")) {
  			response.sendRedirect(request.getContextPath() + "/ViewRecords");
  		}
  		else {
  			out.println("can't delete record,something wrong");
  			RequestDispatcher rd = request.getRequestDispatcher("homePage1.html");
  			rd.include(request, response);
  		}
  	}
}*/

