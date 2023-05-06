package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.FeedbackDAO;
import com.keane.training.domain.Feedback;

public class GiveFeedback implements HttpRequestHandler {
	static Logger log = Logger.getLogger(GiveFeedback.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FeedbackDAO dao = new FeedbackDAO();
		Feedback feedback = new Feedback();
		feedback.setIname(request.getParameter("iname"));
		feedback.setFeedback(request.getParameter("feedback"));
		feedback.setStud_id(Integer.parseInt(request.getParameter("stud_id")));

		boolean isExists;
		try {
				int finalRes = dao.registerFeedback(feedback);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\HomeStud.jsp");
					request.setAttribute("success",
							"Feedback succesfully registered with the system");
					request.setAttribute("details", feedback);
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
