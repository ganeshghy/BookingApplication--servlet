package com.classes.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDao {
	public List<Book> fetchSingleRecord(int bno){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Book> book = new ArrayList<Book>();
		
		try {
			String url = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String pwd = "root";
			
			String query = "select * from booking where bno=?";
			
			con = DriverManager.getConnection(url,user,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Book b = new Book();
				b.setBno(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setLanguage(rs.getString(4));
				b.setPrice(rs.getInt(5));
				
				book.add(b);
			}
			else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}
}
