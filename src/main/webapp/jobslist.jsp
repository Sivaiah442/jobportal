<%@page import="java.util.List"%>
<%@page import="com.jobportal.model.Job"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title>Jobs List</title>
    <link rel="stylesheet" href="joblist.css">
</head>
<body>
<%
    String message = request.getParameter("message");
    if (message != null) {
%>
    <div style="color:green;text-align:center;font-weight:600;margin:18px;">
        <%= message.equals("ApplicationSuccess") ? "You applied successfully!" 
            : (message.equals("ApplicationFailed") ? "Already applied or failed. Try again!" : message) %>
    </div>
<%
    }
%>

    <!-- Home Button -->
    <div style="display: flex; justify-content: flex-start; width: 950px; margin: 22px auto 0 auto;">
        <a href="welcome.jsp" class="home-btn">Home</a>
    </div>
    <!-- Search Bar -->
    <form action="JobsListServlet" method="get" class="search-bar">
        <input type="text" name="search" 
               placeholder="Search jobs, company, or location..." 
               value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>"/>
        <button type="submit" class="home-btn">Search</button>
    </form>

    <%
        List<Job> jobs = (List<Job>) request.getAttribute("jobs");
        if (jobs == null || jobs.isEmpty()) {
    %>
        <p style="text-align:center;">No job postings available.</p>
    <%
        } else {
    %>
    <div class="jobs-container">
        <% for (Job job : jobs) { %>
        <div class="job-card">
            <div class="job-top">
                <span class="company"><%= job.getCompany() %></span>
                <span class="salary"><%= job.getSalary() %></span>
                <span class="location"><%= job.getLocation() %></span>
            </div>
            <div class="job-title"><%= job.getTitle() %></div>
            <div class="job-date">Posted: <%= job.getPostDate() %></div>
            <div class="job-desc"><%= job.getDescription() %></div>
            <form action="ApplyJobServlet" method="post">
                <input type="hidden" name="jobId" value="<%= job.getId() %>"/>
                <button type="submit" class="apply-btn">Apply</button>
            </form>
        </div>
        <% } %>
    </div>
    <%
        }
    %>
</body>
</html>
