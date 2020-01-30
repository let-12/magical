package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String city = request.getParameter("city");
	RegisterDao rd = new RegisterDao();
	List<RegisterM> rs = rd.display(city);
	
	List<RegisterM> sm = new ArrayList<RegisterM>();
	sm= rd.display(city);
	try{
PrintWriter out= response.getWriter();
		
		out.println("<table width=25% border=1>");
		out.println("<center><h1>result:</h1><center>");
		for(RegisterM str: rs)
		{
			out.println("<tr><th>" + str.getName() +"</tr></th>");
		}
		 out.print("</table>");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	}

	
}
