package com.ns.naturalapp.repo;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/natural_db";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static ResultSet selectAction(String selectStatement) {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASS);
            Statement statement = connection.createStatement()){
            return statement.executeQuery(selectStatement);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
