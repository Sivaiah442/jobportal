package com.jobportal.servlets;
import com.jobportal.dao.UserDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    // Create instance of UserDao and attempt to save user
	    UserDao userDao = new UserDao();
	    boolean registered = userDao.saveUser(username, email, password);

	    // Forward or redirect based on result
	    if (registered) {
	        request.getRequestDispatcher("registersuccsess.jsp").forward(request, response);
	    } else {
	        request.setAttribute("message", "User name is already taken.");
	        request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	}
}

