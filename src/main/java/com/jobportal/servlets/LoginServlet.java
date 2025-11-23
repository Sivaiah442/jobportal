package com.jobportal.servlets;
import com.jobportal.dao.UserDao;

import java.io.IOException;
import com.jobportal.dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDao userDao=new UserDao();
		boolean validUser=userDao.validateUser(username,password);
		if (validUser) {
            // Create session and redirect to welcome/dashboard page
			HttpSession session = req.getSession();
			int userId = userDao.getUserId(username); // Implement getUserId in UserDao
			session.setAttribute("userId", userId);
			resp.sendRedirect("welcome.jsp");
        } 
        	else {
        	    req.setAttribute("message", "Invalid, please try again!");
        	    req.getRequestDispatcher("login.jsp").forward(req, resp);  // Forward to login.jsp itself, not register.jsp
        	}
        }	
		
	}
       
 
