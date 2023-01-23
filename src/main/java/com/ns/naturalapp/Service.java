package com.ns.naturalapp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {


    public void method(Query query){

        String queryString = query.getQueryString();

        try(ResultSet resultSet = DatabaseConnection.selectAction(queryString)) {

            while(resultSet.next()) {


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
