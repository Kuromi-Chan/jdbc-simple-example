package org.example.dao;

import org.example.utils.ConnectionManager;
import org.example.models.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDAO {

    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;


    public ArtistDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection con = null;
        con = ConnectionManager.getInstance().getConection();
        return con;
    }

    public void add(Artist artist)  {
        String queryString = "INSERT INTO Artist (name) values (?)";
        try (Connection connection = getConnection();
             PreparedStatement ptmt = connection.prepareStatement(queryString)) {
            ptmt.setString(1, artist.getName());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Artist artist){
        String queryString = "UPDATE Artist SET name=? WHERE Id =?";
        try (Connection connection = getConnection();
             PreparedStatement ptmt = connection.prepareStatement(queryString)) {
            ptmt.setString(1, artist.getName());
            ptmt.executeUpdate();
            System.out.println("Table Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Artist artist){
        String queryString = "DELETE FROM Artist  WHERE name =?";
        try (Connection connection = getConnection();
             PreparedStatement ptmt = connection.prepareStatement(queryString)) {
            ptmt.setString(1, artist.getName());
            ptmt.executeUpdate();
            System.out.println("The Row Deleted Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void findAll(){
        String queryString = "SELECT * FROM Artist";
        try (Connection connection = getConnection();
             PreparedStatement ptmt = connection.prepareStatement(queryString)) {
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("The artist name: " + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

