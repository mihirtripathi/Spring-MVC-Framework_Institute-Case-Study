package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.StudentUpdateDAO;
import com.keane.training.domain.Student;

/**
 * Servlet implementation class StudentUpdate
 */
public class StudentUpdate implements com.keane.mvc.HttpRequestHandler {
	private static final long serialVersionUID = 1L;

	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		int stud_id=Integer.parseInt(request.getParameter("stud_id"));
		StudentUpdateDAO dao = new StudentUpdateDAO();
		int res=dao.updateStudent(email,stud_id);
		System.out.println(res);
		if(res>0) {
			RequestDispatcher rd=request.getRequestDispatcher("StudentUpdate.jsp");
			request.setAttribute("Err", "Email Updated");
					rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", "Unable to update");
					rd.forward(request, response);
		}
	}
	

}