package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.StudentRegisterDAO;
import com.keane.training.domain.Student;

public class RegisterStudent implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterStudent.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentRegisterDAO dao = new StudentRegisterDAO();
		Student student = new Student();
		student.setStud_id(Integer.parseInt(request.getParameter("stud_id")));
		student.setSname(request.getParameter("sname"));
		student.setSqualification(request.getParameter("squalification"));
		student.setScontact(request.getParameter("scontact"));
		student.setSaddress(request.getParameter("saddress"));
		student.setEmail(request.getParameter("email"));


		boolean isExists;
		try {
			isExists = dao.validateStudent(student.getStud_id());

			if (isExists) {
				log.info("Student already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\StudentRegister.jsp");
				request.setAttribute("Err",
						"User already registered with the system");
				dispatcher.forward(request, response);
			} else {
				student.setSpassword("NttData@"+ Integer.toString(student.getStud_id()));
				int finalRes = dao.registerStudent(student);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\index.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", student);
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

