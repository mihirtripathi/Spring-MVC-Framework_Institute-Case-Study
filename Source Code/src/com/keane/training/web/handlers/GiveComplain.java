package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.ComplainDAO;
import com.keane.training.domain.Complain;

public class GiveComplain implements HttpRequestHandler {
	static Logger log = Logger.getLogger(GiveComplain.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ComplainDAO dao = new ComplainDAO();
		Complain complain = new Complain();
		complain.setStud_id(Integer.parseInt(request.getParameter("stud_id")));
		complain.setIname(request.getParameter("iname"));
		complain.setComplain(request.getParameter("complain"));

		boolean isExists;
		try {
				int finalRes = dao.registerComplain(complain);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\HomeStud.jsp");
					request.setAttribute("success",
							"Complain succesfully registered with the system");
					request.setAttribute("details", complain);
					dispatcher.forward(request, response);
				}
			}
		catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
