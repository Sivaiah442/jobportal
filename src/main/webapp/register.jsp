<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
    <link rel="stylesheet" href="regitration.css"> 
</head>
<body>
    <div class="form-container">
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" name="username" placeholder="Username" required />
            <input type="email" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Password" required />
            <button type="submit">Register</button>
        </form>
        <%-- Display error message if exists --%>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <p style="color:red; margin-top:10px;"><%= message %></p>
        <%
            }
        %>
    </div>
</body>
</html>
