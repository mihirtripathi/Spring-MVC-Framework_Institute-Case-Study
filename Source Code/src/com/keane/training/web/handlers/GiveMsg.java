package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.MsgDAO;
import com.keane.training.domain.Msg;

public class GiveMsg implements HttpRequestHandler {
	static Logger log = Logger.getLogger(GiveMsg.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MsgDAO dao = new MsgDAO();
		Msg msg = new Msg();
		msg.setIname(request.getParameter("iname"));
		msg.setMsg(request.getParameter("msg"));

		boolean isExists;
		try {
				int finalRes = dao.registerMsg(msg);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\home.jsp");
					request.setAttribute("success",
							"Message Sent succesfully with the system");
					request.setAttribute("details", msg);
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

