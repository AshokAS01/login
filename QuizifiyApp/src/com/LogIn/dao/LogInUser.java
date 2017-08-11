package com.LogIn.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class LogInUser {
	
	
	public static int validate(String name, String pass,int flag) {
		// This program validates the user id and password

		String query1 = "select * from user_login";
		 String query2="insert into user_login values(?,?)";
		 String query3="SELECT * FROM faculty;";
		 int status=0; 
			Connection conn=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
	
		
		System.out.println(name);
		System.out.println(pass);
		System.out.println("form data");
		try {

			 System.out.println("entered try");
			 Class.forName("com.mysql.jdbc.Driver");

			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
				

		
		if (flag==1){
			
	
			PreparedStatement ps=conn.prepareStatement(query1);  

			System.out.println(query1);
			 rs = ps.executeQuery();

			while (rs.next()) {

				/*System.out.println(rs.getInt(1));*/
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));

				if ((name.equals(rs.getString(1)))) {

					if (pass.equals(rs.getString(2))) {

					status = 1;
					break;
					} else {

					status = 2;
					break;
					}
				}
		
			}
		}if(flag==2){
			
			
			 pst=conn.prepareStatement(query2);
			/*pst.setInt(1,1030);*/
			pst.setString(1, name);
			pst.setString(2, pass);
			pst.executeUpdate();
			
		}if(flag==3){
			
			
			PreparedStatement ps=conn.prepareStatement(query3);  

			System.out.println(query3);
			 rs = ps.executeQuery();

			while (rs.next()) {

				/*System.out.println(rs.getInt(1));*/
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));

				if ((name.equals(rs.getString(1)))) {

					if (pass.equals(rs.getString(2))) {

					status = 1;
					break;
					} else {

					status = 2;
					break;
					}
				}
			}
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		}
	}
	


	