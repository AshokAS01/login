package com.LogIn.Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SubjectDelete
 */
@WebServlet("/SubjectDelete")
public class SubjectDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
     int x=0;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sub=request.getParameter("s1");
		
		System.out.println("Subject Name: "+sub);

		String query1= "delete from subject1 where subName = ?";

	
		Connection conn = null;
		PreparedStatement pst = null;
		
		System.out.println(sub);
		
		System.out.println("form data");
		try {

			System.out.println("entered try");
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");

				pst = conn.prepareStatement(query1);

				
				int x=pst.executeUpdate();
				if(x>0){
					 RequestDispatcher rd=request.getRequestDispatcher("delete.html");  
				        rd.forward(request,response); 
				     
				    }  
				    else {  
				        out.println(" Please Try Again");  
				        RequestDispatcher rd=request.getRequestDispatcher("subDelete.html");  
				        rd.include(request,response);  
				    } 
				
		} catch (Exception e) {
			System.out.println(e);
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
