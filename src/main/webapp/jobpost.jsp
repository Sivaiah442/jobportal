<!DOCTYPE html>
<html>
<head>
    <title>Post a Job</title>
    <link rel="stylesheet" href="jobpost.css">
</head>
<body>
    <!-- Home button container, above the card -->
    <div style="display: flex; justify-content: flex-start; width: 410px; margin: 34px auto 10px auto;">
      <a href="welcome.jsp" class="home-btn">Home</a>
    </div>
    <div class="jobpost-container">
        <h2>Post a Job</h2>
        <form action="PostJobServlet" method="post">
            <input type="text" name="title" placeholder="Job Title" required>
            <textarea name="description" placeholder="Job Description" rows="4" required></textarea>
            <input type="text" name="company" placeholder="Company Name" required>
            <input type="text" name="location" placeholder="Location" required>
            <input type="text" name="salary" placeholder="Salary" required>
            <button type="submit" class="submit-btn">Post Job</button>
        </form>
    </div>
</body>
</html>
