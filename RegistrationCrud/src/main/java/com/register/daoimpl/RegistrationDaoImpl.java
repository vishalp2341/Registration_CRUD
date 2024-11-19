package com.register.daoimpl;

import com.register.dao.RegistrationDao;
import com.register.model.Registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDaoImpl implements RegistrationDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/regist";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "root";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public int save(Registration registration) {
        String query = "INSERT INTO Registration (Name, Email, DateOfBirth, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, registration.getName());
            ps.setString(2, registration.getEmail());
            ps.setDate(3, new java.sql.Date(registration.getDateOfBirth().getTime()));
            ps.setString(4, registration.getPhoneNumber());
            ps.setString(5, registration.getAddress());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Registration> getAll() {
        List<Registration> list = new ArrayList<>();
        String query = "SELECT * FROM Registration";
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Registration(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getDate("DateOfBirth"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Registration getById(int id) {
        String query = "SELECT * FROM Registration WHERE ID = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Registration(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getDate("DateOfBirth"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Registration registration) {
        String query = "UPDATE Registration SET Name = ?, Email = ?, DateOfBirth = ?, PhoneNumber = ?, Address = ? WHERE ID = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, registration.getName());
            ps.setString(2, registration.getEmail());
            ps.setDate(3, new java.sql.Date(registration.getDateOfBirth().getTime()));
            ps.setString(4, registration.getPhoneNumber());
            ps.setString(5, registration.getAddress());
            ps.setInt(6, registration.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM Registration WHERE ID = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
