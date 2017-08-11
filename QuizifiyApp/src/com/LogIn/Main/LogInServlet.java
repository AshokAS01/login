package com.LogIn.Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LogIn.dao.LogInUser;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uid");
		String pass=request.getParameter("pwd");
		
		System.out.println("username: "+uname);
		System.out.println("password: "+pass);
		
		
		int status=0;
		int flag=1;
		
				status = LogInUser.validate(uname, pass,flag);
				
				if(status==1){
				     RequestDispatcher rd=request.getRequestDispatcher("subject.html");  
					        rd.forward(request,response); 
					     
					    }  
					    else if(status==2){  
					        out.println(" :Sorry username or password are wrong");  
					        RequestDispatcher rd=request.getRequestDispatcher("form.html");  
					        rd.include(request,response);  
					    } 
				       else if (status == 0) {

					RequestDispatcher rd = request.getRequestDispatcher("SignUp.html");
					rd.include(request, response);
				}
		
			 
		
		
		          
		}
		    
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
