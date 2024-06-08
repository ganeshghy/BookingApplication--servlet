package com.classes.dao;

import java.sql.*;

public class LoginDao {
	public String check(String username, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String pwd = "root";
			
			String sql = "select uname,password from login where uname=? AND password=?";
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(query,user,pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//                if (pstmt != null) pstmt.close();
//                if (con != null) con.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//		}
		if(rs.next()) {
			return "SUCCESS";
		}
		else {
			return "FAIL";
		}
	}
}
