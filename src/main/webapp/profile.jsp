<%@ page import="com.jobportal.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <title>My Profile</title>
    <link rel="stylesheet" href="profile.css">
</head>
<body>
<div class="top-nav">
    <a href="welcome.jsp" class="nav-btn">Home</a>
    <a href="JobsListServlet" class="nav-btn">View Jobs</a>
</div>


   <div class="profile-container">
    <h2>My Profile</h2>
    <table class="profile-table">
        <tr>
            <th>Full Name</th>
            <td><%= user.getFullName() %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= user.getEmail() %></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><%= user.getPhone() %></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><%= user.getAddress() %></td>
        </tr>
    </table>
    <a href="EditProfileServlet" class="edit-link">Edit Profile</a>
</div>
   
</html>
