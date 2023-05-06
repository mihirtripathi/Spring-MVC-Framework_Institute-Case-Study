package com.keane.training.web.handlers;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;


public class AdminLogin implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(AdminLogin.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//PrintWriter out = response.getWriter();
		//int userid = Integer.parseInt(request.getParameter("userid"));
		//String password = request.getParameter("password");
		
		

    	//response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String url = "";
		
		if(userid.equals("iamadmin")  && password.equals("win1234") )
		{
			
			url = "home.jsp";
			// session api
			//HttpSession usersession = request.getSession();
			//usersession.setAttribute("username",username);
		}
		else
		{
			
			url = "error.jsp";
		}
		 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		 
 		
		
		
		
		
	/*	int flag = -1;
		List users = null;
		LoginDAO dao = new LoginDAO();
		try {
			users = dao.validateUser(portalid);
			log.info(users);
			for (Object object : users) 
			{

				User user = (User) object;
				if (user.getPassword().equals(password)) 
				{
					flag = 0;
					break;
				}
			}
			log.info("Flag in login " + flag);
			
			if (flag == 0) 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				request.setAttribute("Name", portalid);
				dispatcher.forward(request, response);

			} else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("Err","username are password is incorrect");
				dispatcher.forward(request, response);
			}

		} catch (DAOAppException e) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

		}*/

	}
}
