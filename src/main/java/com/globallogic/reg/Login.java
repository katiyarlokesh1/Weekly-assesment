package com.globallogic.reg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String usrname2=req.getParameter("usname1");
		String pass2=req.getParameter("passrd1");
		
		req.setAttribute("username", usrname2);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc.mysql://localhost:3306/company","root","root");
			PreparedStatement ps=con.prepareStatement("select * from employee where first_name=? and password=?");
			
			ps.setString(1,usrname2);
			ps.setString(2,pass2);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				resp.sendRedirect("profile.jsp");
			}
			else
			{
				RequestDispatcher rd3=req.getRequestDispatcher("Error.jsp");
				rd3.forward(req, resp);
				
				RequestDispatcher rd4=req.getRequestDispatcher("login.jsp");
				rd3.include(req, resp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
//		if(usrname2.equals("akash") && pass2.equals("123"))
//		{
//			RequestDispatcher rd2=req.getRequestDispatcher("profile.jsp");
//			rd2.forward(req, resp);
//		}
//		else
//		{
//			RequestDispatcher rd3=req.getRequestDispatcher("Error.jsp");
//			rd3.forward(req, resp);
//			
//			RequestDispatcher rd4=req.getRequestDispatcher("login.jsp");
//			rd3.include(req, resp);
//		}
	}
}
