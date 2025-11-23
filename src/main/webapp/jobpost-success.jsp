<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Posted Successfully</title>
<link rel="stylesheet" href="jobpost.css">  <!-- Reuse the jobpost CSS or create a new one -->
</head>
<body>
    <div class="form-container">
        <h2>Job Posted Successfully!</h2>
        <p>Your job has been posted and is now live on the portal.</p>
        <form action="JobsListServlet" method="get">
            <button type="submit">View All Jobs</button>  <!-- You will create jobslist.jsp next -->
        </form>
    </div>
</body>
</html>
