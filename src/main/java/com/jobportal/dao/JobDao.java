package com.jobportal.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.jobportal.model.Job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JobDao {
    // Database connection details
     String jdbcURL = "jdbc:mysql://localhost:3306/jobportal";
     String jdbcUsername = "root";
     String jdbcPassword = "password";// Add this as the first method in your JobDao class
     private Connection getConnection() throws Exception {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    return DriverManager.getConnection(
    	        "jdbc:mysql://localhost:3306/jobportal", "root", "@1Sivaiah"
    	    );
    	}


    // Save a job post to database
    public boolean saveJob(String title, String description, String company, String location, String salary) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "INSERT INTO jobs (title, description, company, location, salary) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, company);
            ps.setString(4, location);
            ps.setString(5, salary);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = true;
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String sql = "SELECT * FROM jobs ORDER BY post_date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description")); // spelling fixed!
                job.setCompany(rs.getString("company"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getString("salary"));
                job.setPostDate(rs.getDate("post_date")); // assuming java.sql.Date

                jobs.add(job);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }
 // This must be inside JobDao class
    public List<Job> searchJobs(String keyword) {
        List<Job> jobList = new ArrayList<>();
        String sql = "SELECT * FROM jobs WHERE title LIKE ? OR company LIKE ? OR location LIKE ? OR description LIKE ?";
        try (Connection conn = getConnection(); // Make sure getConnection() method exists in JobDao!
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String filter = "%" + keyword.trim() + "%";
            ps.setString(1, filter);
            ps.setString(2, filter);
            ps.setString(3, filter);
            ps.setString(4, filter);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setCompany(rs.getString("company"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getString("salary"));
                job.setPostDate(rs.getTimestamp("post_date")); // Change this if your field is named differently
                jobList.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobList;
    }

    
}

