<%@page import="com.jobportal.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>Edit Profile</title>
    <link rel="stylesheet" href="profile.css">
</head>
<body>
<div class="top-nav">
    <a href="welcome.jsp" class="nav-btn">Home</a>
    <a href="JobsListServlet" class="nav-btn">View Jobs</a>
</div>

<div class="profile-container">
    <h2>Edit Profile</h2>
    <form method="post" action="EditProfileServlet">
    <input type="hidden" name="id" value="<%= user.getId() %>">
        <table class="profile-table">
            <tr>
                <th>Full Name</th>
                <td><input type="text" name="fullName" value="<%= user.getFullName() != null ? user.getFullName() : "" %>" required></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="email" name="email" value="<%= user.getEmail() != null ? user.getEmail() : "" %>" required></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><input type="text" name="phone" value="<%= user.getPhone() != null ? user.getPhone() : "" %>" required></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><textarea name="address" rows="2" required><%= user.getAddress() != null ? user.getAddress() : "" %></textarea></td>
            </tr>
        </table>
        <button type="submit" class="save-btn">Save</button>
    </form>
</div>
</body>
</html>
