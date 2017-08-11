package com.LogIn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddQuestion {
	
	public static int addQuestion(String que, String ans, int flag) {
		// This program validates the user id and password

		String query1 = "insert into question1 values(?,?)";
		
		int status = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		System.out.println(que);
		System.out.println(ans);
		System.out.println("form data");
		try {

			System.out.println("entered try");
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");

			
			if (flag == 1) {

				pst = conn.prepareStatement(query1);

				pst.setString(1, que);
				pst.setString(2, ans);
				pst.executeUpdate();

			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

}
