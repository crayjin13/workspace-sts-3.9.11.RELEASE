package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */

public class GugudanServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		/*
		for(int i=0;i<9;i++) {
			for (int j = 0; j < 8;j++) {
				out.print("2*1=2\t");
			}
			out.println();
		}
		*/
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>방가워요 서블릿</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<center>");
		out.println("<center><H2>서블릿 잘났어 정말 별꼴이야!!!!!!!!!</H2><center>");
		out.println("<img src='./tomcat.gif'/>");
				out.println("<center><H2>서블릿 구구단</H2></center>");
		out.println("<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600 cellspacing=0>");
		out.println("<tr>");
		out.println("<td align=center>2*1=2</td>");
		out.println("<td align=center>2*1=2</td>");
		out.println("<td align=center>2*1=2</td>");
		out.println("<td align=center>2*1=2</td>");
		out.println("<td align=center>2*1=2</td>");
		out.println("<td align=center>2*1=2</td>");
		out.println("<td align=center>2*1=2</td>");
		out.println("<td align=center>2*1=2</td>");
		out.println("</tr>");
	
	

		out.println("</table>");
		out.println("<br/>");
		out.println("</center>");
		out.println("</BODY>");
		out.println("</HTML>");
		
	}

}












