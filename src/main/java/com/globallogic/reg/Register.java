package com.globallogic.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String fname2=req.getParameter("fname1");
		String lname2=req.getParameter("lname1");
		String uname2=req.getParameter("uname1");
		String pass2=req.getParameter("pass1");
		String address2=req.getParameter("address1");
		String contact2=req.getParameter("contact1");
		String email2=req.getParameter("email1");
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
//		out.println(fname2);
//		out.print(lname2);
		
		req.setAttribute("fname3",fname2);
		req.setAttribute("lname3",lname2);
		req.setAttribute("uname3",uname2);
		req.setAttribute("pass3",pass2);
		req.setAttribute("address3",address2);
		req.setAttribute("contact3",contact2);
		req.setAttribute("email3",email2);
		
		
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:myql://localhost:3306/company","root","root");
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			
			ps.setString(1,fname2);
			ps.setString(2, lname2);
			ps.setString(3,uname2);
			ps.setString(4,pass2);
			ps.setString(5, address2);
			ps.setString(6, contact2);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				resp.sendRedirect("profile.jsp");
			}
			else
			{
				out.print("failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}			
	
}
