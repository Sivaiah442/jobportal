package com.jobportal.servlets;

import com.jobportal.dao.ApplicationDao; // You will create ApplicationDao for DB insert
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ApplyJobServlet")
public class ApplyJobServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userId") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }
	    int userId = (int) session.getAttribute("userId");
	    int jobId = Integer.parseInt(request.getParameter("jobId"));

	    ApplicationDao applicationDao = new ApplicationDao();
	    boolean applied = applicationDao.applyForJob(userId, jobId);

	    if (applied) {
	        response.sendRedirect("JobsListServlet?message=ApplicationSuccess");
	    } else {
	        response.sendRedirect("JobsListServlet?message=ApplicationFailed");
	    }
	}
}