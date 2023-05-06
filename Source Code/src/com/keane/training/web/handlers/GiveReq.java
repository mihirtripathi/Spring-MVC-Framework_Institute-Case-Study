package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.RequestDAO;
import com.keane.training.domain.Req;

public class GiveReq implements HttpRequestHandler {
	static Logger log = Logger.getLogger(GiveReq.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDAO dao = new RequestDAO();
		Req req = new Req();
		req.setIname(request.getParameter("iname"));
		req.setStud_id(Integer.parseInt(request.getParameter("stud_id")));
		req.setReq(request.getParameter("req"));

		boolean isExists;
		try {
				int finalRes = dao.registerReq(req);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\HomeStud.jsp");
					request.setAttribute("success",
							"Request succesfully registered with the system");
					request.setAttribute("details", req);
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

