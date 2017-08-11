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
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String que = request.getParameter("qname");
		String ans = request.getParameter("answ");
		String sn = request.getParameter("sname");

		System.out.println("Question name: " + que);
		System.out.println("Answer: " + ans);

		String query1 = "insert into question1 values(?,?,?)";

		int status = 0;
		Connection conn = null;
		PreparedStatement pst = null;

		int rn = (int) (Math.random() * 50 + 1);
		System.out.println(que);
		System.out.println(sn);
		System.out.println("form data");
		try {

			System.out.println("entered try");
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");

			pst = conn.prepareStatement(query1);
			pst.setInt(1, rn);
			pst.setString(2, que);
			pst.setString(3, sn);

			status = pst.executeUpdate();
			/*out.println(rn);
			out.println(que);
			out.println(sn);*/

			if (status > 0) {
				int qn = 0;
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
				PreparedStatement pst3 = con.prepareStatement("select qid from question1 where subject=? ");
				pst3.setString(1, sn);
				ResultSet rs3 = pst3.executeQuery();
				while (rs3.next()) {
					qn = rs3.getInt(1);
				}
				PreparedStatement pst4 = con.prepareStatement("insert into answer1 values(?,?,?) ");
				pst4.setInt(1, 1);
				pst4.setString(2, ans);
				pst4.setInt(3, qn);
				int h = pst4.executeUpdate();
				if (h > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("final.html");
					rd.include(request, response);

				} else {

					RequestDispatcher rd = request.getRequestDispatcher("error.html");
					rd.include(request, response);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
