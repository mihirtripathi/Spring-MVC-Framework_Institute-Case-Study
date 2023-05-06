package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.InstituteRegisterDAO;
import com.keane.training.domain.Institute;

public class RegisterInstitute implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterInstitute.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InstituteRegisterDAO dao = new InstituteRegisterDAO();
		Institute institute = new Institute();
		institute.setIname(request.getParameter("iname"));
		institute.setIpassword(request.getParameter("ipassword"));
		institute.setIaddress(request.getParameter("iaddress"));
		institute.setNseats(Integer.parseInt(request.getParameter("nseats")));
		institute.setNcourses(Integer.parseInt(request.getParameter("ncourses")));
		institute.setNfaculty(Integer.parseInt(request.getParameter("nfaculty")));

		boolean isExists;
		try {
			isExists = dao.validateInstitute(institute.getIname());

			if (isExists) {
				log.info("Institute already registered with Same Name");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\InstituteRegister.jsp");
				request.setAttribute("Err",
						"User already registered with the system");
				dispatcher.forward(request, response);
			} else {
				//institute.setIpassword("NttData@"+ institute.getIname());
				int finalRes = dao.registerInstitute(institute);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\SuccessIns.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", institute);
					dispatcher.forward(request, response);
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
