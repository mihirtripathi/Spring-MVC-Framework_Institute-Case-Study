package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.InstituteDeleteDAO;
import com.keane.training.domain.Institute;

/**
 * Servlet implementation class InstituteDelete
 */
public class InstituteDelete implements com.keane.mvc.HttpRequestHandler {
	private static final long serialVersionUID = 1L;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String iname = request.getParameter("iname");
		int del=-1;
		del=InstituteDeleteDAO.deleteInstitute(iname);
		if(del==0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("..\\pages\\InstituteDelete.jsp");
			request.setAttribute("Err","Institute "+iname+" already deleted or not present ");
			rd.forward(request, response);
		}
		else {
		RequestDispatcher rd = request.getRequestDispatcher("..\\pages\\home.jsp");
		request.setAttribute("successdelete","Institute "+iname+" deleted succesfully");
		rd.forward(request, response);
		}
	}
	

}