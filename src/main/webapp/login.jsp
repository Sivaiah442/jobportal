<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login | Job Portal</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div class="form-container">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />
            <button type="submit">Login</button>
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
        <p style="margin-top:16px;">
            New user? <a href="register.jsp">Sign Up Here</a>
        </p>
    </div>
</body>
</html>
