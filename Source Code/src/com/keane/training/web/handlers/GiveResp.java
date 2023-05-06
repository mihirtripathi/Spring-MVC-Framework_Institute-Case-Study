package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.RespDAO;
import com.keane.training.domain.Resp;

public class GiveResp implements HttpRequestHandler {
	static Logger log = Logger.getLogger(GiveResp.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RespDAO dao = new RespDAO();
		Resp resp = new Resp();
		resp.setStud_id(Integer.parseInt(request.getParameter("stud_id")));
		resp.setIname(request.getParameter("iname"));
		resp.setResp(request.getParameter("resp"));

		boolean isExists;
		try {
				int finalRes = dao.registerResp(resp);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\HomeIns.jsp");
					request.setAttribute("success",
							"Responded succesfully with the system");
					request.setAttribute("details", resp);
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

