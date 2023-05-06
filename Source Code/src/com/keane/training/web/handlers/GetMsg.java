package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.MsgDAO;

public class GetMsg implements HttpRequestHandler {

    public static Logger log = Logger.getLogger(GetMsg.class);

    public void handle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try {
            List msglist = MsgDAO.getMsg();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("GetMsg.jsp");
            request.setAttribute("msglist", msglist);
            dispatcher.forward(request, response);
        } catch (DBFWException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DBConnectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //<% List studentlist = (List) request.getAttribute("studlist"); %>
        //for(Employee emp :((ArrayList<Employee>)request.getAttribute("employeedetails")))
    }
}