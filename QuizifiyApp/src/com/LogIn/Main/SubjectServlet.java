package com.LogIn.Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
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
		String desp=request.getParameter("s2");
		
		System.out.println("SubjectName: "+sub);
		System.out.println("SubjectDecription: "+desp);
		
	/*	out.println(sub);
		out.println(desp);
		*/
		
         String query1 = "insert into subject1 values(?,?)";
	
		int status = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		System.out.println(sub);
		System.out.println(desp);
		System.out.println("form data");
		try {

			System.out.println("entered try");
			Class.forName("com.mysql.jdbc.Driver");
System.out.println("diver entered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");

			
			System.out.println("driver work well");

				pst = conn.prepareStatement(query1);

				pst.setString(1, sub);
				pst.setString(2, desp);
				status=pst.executeUpdate();


				if(status>0){
				     RequestDispatcher rd=request.getRequestDispatcher("question.html");  
					        rd.forward(request,response); 
					     
					 } else  {

					RequestDispatcher rd = request.getRequestDispatcher("error.html");
					rd.include(request, response);
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
