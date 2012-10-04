package com.pcwerk.seck.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter();
    String name = request.getParameter("name");
    out.println("Hello + " + name + "!");
    out.println("<a href=index.jsp>back to form</a>");
  }
}
