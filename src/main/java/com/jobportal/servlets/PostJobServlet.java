package com.jobportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jobportal.dao.JobDao;

@WebServlet("/PostJobServlet")
public class PostJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String company = request.getParameter("company");
        String location = request.getParameter("location");
        String salary = request.getParameter("salary");

        JobDao jobDao = new JobDao();
        boolean result = jobDao.saveJob(title, description, company, location, salary);

        if (result) {
            response.sendRedirect("jobpost-success.jsp");  // Create this success page or redirect to jobs list
        } else {
            request.setAttribute("message", "Failed to post job. Please try again.");
            request.getRequestDispatcher("postjob.jsp").forward(request, response);
        }
    }
}
