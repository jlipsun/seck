package com.pcwerk.seck.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import com.pcwerk.seck.model.*;

public class Jstl extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {    
    ArrayList<JstlData> list = new ArrayList<JstlData>();
    list.add(new JstlData("Sunday"));
    list.add(new JstlData("Monday")); 
    list.add(new JstlData("Tuesday")); 
    list.add(new JstlData("Wedneday")); 
    list.add(new JstlData("Thrusday")); 
    list.add(new JstlData("Friday")); 
    list.add(new JstlData("Saturday")); 
    
        request.setAttribute("Output", list);
    
    String url = "/WEB-INF/jstl.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
  }
}

