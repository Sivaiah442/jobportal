package com.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplicationDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/jobportal";
    private String jdbcUsername = "root";
    private String jdbcPassword = "@1Sivaiah";

    public boolean applyForJob(int userId, int jobId) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // Corrected column names to match your table: 'user_id', 'job_id'
            String checkSql = "SELECT id FROM applications WHERE user_id = ? AND job_id = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, userId);
            checkPs.setInt(2, jobId);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                conn.close();
                return false; // User already applied, do not insert again
            }

            String sql = "INSERT INTO applications (user_id, job_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, jobId);
            int rows = ps.executeUpdate();
            if (rows > 0) result = true;

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
