package com.jobportal.servlets;
import com.jobportal.model.User;

import com.jobportal.dao.UserDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userId") == null) {
	        response.sendRedirect("login.jsp");        return;
	    }
	    int userId = (int) session.getAttribute("userId");
	    UserDao userDao = new UserDao();
	    User user = userDao.getUserById(userId);
	    request.setAttribute("user", user);
	    request.getRequestDispatcher("editprofile.jsp").forward(request, response);
	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        User user = new User();
        user.setId(id);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);

        UserDao userDao = new UserDao();
        boolean updated = userDao.updateUser(user);

        if (updated) {
            response.sendRedirect("ProfileServlet");
        } else {
            response.sendRedirect("editprofile.jsp?error=1");
        }
    }
}

