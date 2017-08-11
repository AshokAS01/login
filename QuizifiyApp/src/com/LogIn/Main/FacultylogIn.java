package com.LogIn.Main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LogIn.dao.LogInUser;

/**
 * Servlet implementation class FacultylogIn
 */
@WebServlet("/FacultylogIn")
public class FacultylogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultylogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hiii");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uid");
		String pass=request.getParameter("pwd");
		
		System.out.println("username: "+uname);
		System.out.println("password: "+pass);
		
		int flag=3;
		int status=0;
		
		
				status = LogInUser.validate(uname, pass,flag);
				
				if(status==1){
				     RequestDispatcher rd=request.getRequestDispatcher("subject.html");  
					        rd.forward(request,response); 
					     
					    }  
					    else {  
					        out.println(" :::::<h1>Sorry Username or Password are Wrong Please Try Again!</h1>");  
					        RequestDispatcher rd=request.getRequestDispatcher("fLogIn.html");  
					        rd.include(request,response);  
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
