package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.InstituteLoginDAO;
import com.keane.training.domain.Institute;

public class InstituteLogin implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(InstituteLogin.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String iname = request.getParameter("iname");
		String ipassword = request.getParameter("ipassword");
		int flag = -1;
		List institutes = null;
		InstituteLoginDAO dao = new InstituteLoginDAO();
		try {
			institutes = dao.validateInstitute(iname);
			log.info(institutes);
			for (Object object : institutes) {

				Institute institute = (Institute) object;
				if (institute.getIname().equals(iname)) {
					flag = 0;
					break;
				}
			}
			log.info("Flag in login " + flag);
			if (flag == 0) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("HomeIns.jsp");
				request.setAttribute("Name", iname);
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("InstituteLogin.jsp");
				request.setAttribute("Err",
						"username are password is incorrect");
				dispatcher.forward(request, response);
			}

		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

		}

	}
}

