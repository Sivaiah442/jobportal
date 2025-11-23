package com.jobportal.servlets;

import com.jobportal.dao.JobDao;
import com.jobportal.model.Job;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/JobsListServlet")
public class JobsListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        JobDao jobDao = new JobDao();
        List<Job> jobs;

        if (search != null && !search.trim().isEmpty()) {
            jobs = jobDao.searchJobs(search);
        } else {
            jobs = jobDao.getAllJobs();
        }

        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("jobslist.jsp").forward(request, response);
    }
}
