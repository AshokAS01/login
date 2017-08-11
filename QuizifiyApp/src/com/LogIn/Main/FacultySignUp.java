package com.LogIn.Main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LogIn.dao.LogInUser;

/**
 * Servlet implementation class FacultySignUp
 */
@WebServlet("/FacultySignUp")
public class FacultySignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultySignUp() {
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
		String uname=request.getParameter("email");
		String pass=request.getParameter("psw");
		
		System.out.println("username: "+uname);
		System.out.println("password: "+pass);
		
		int status = 0;
		int flag=3;
	
			status=LogInUser.validate(uname, pass,flag);
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
