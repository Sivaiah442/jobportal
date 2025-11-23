package com.jobportal.dao;
import com.jobportal.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	String url="jdbc:mysql://localhost:3306/jobportal";
	String User="root";
	String Password="@1Sivaiah";
	public boolean saveUser(String username, String email, String password) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, User,Password);
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            int rows = ps.executeUpdate();
            if (rows > 0) result = true;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	public boolean validateUser(String username, String password) {
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, User, Password);
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}
	// Fetch user details by ID
	public User getUserById(int userId) {
	    User user = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, User, Password);
	        String sql = "SELECT * FROM users WHERE id = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setFullName(rs.getString("full_name")); // Correct column name!
	            user.setPhone(rs.getString("phone"));
	            user.setAddress(rs.getString("address"));
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return user;
	}

	public int getUserId(String username) {
	    int id = -1;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, User, Password);
	        String sql = "SELECT id FROM users WHERE username = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            id = rs.getInt("id");
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return id;
	}


	// Update user details
	public boolean updateUser(User user) {
	    boolean updated = false;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, User, Password);

	        String sql = "UPDATE users SET full_name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getFullName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPhone());
	        ps.setString(4, user.getAddress());
	        ps.setInt(5, user.getId());

	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            updated = true;
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return updated;
	}
	
	

}
	


