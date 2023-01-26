package com.ns.naturalapp.repo;

import com.ns.naturalapp.EntityDTO;
import com.ns.naturalapp.Query;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JDBCEntityRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/natural_app";
    private static final String USER = "root";
    private static final String PASS = "root";

    public EntityDTO getEntity(Query query){

        String queryString = query.getQueryString();
        EntityDTO entity = new EntityDTO();
        entity.setName(query.getView().getName());
        entity.setAttributeTitles(query.getColumnNamesAsList());
        Map<Long, List<Object>> attributeValuesById = new HashMap<>();


        try(Connection connection = DriverManager.getConnection(URL,USER,PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString)) {
            
            assert resultSet != null;
            ResultSetMetaData metaData = resultSet.getMetaData();
            entity.setName(metaData.getTableName(1));


            while(resultSet.next()) {
                long id = 0;
                List<Object> attributeValues = new ArrayList<>();
                
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if(metaData.isAutoIncrement(i)){
                        id = resultSet.getLong(i);
                    }else {
                        attributeValues.add(resultSet.getObject(i));
                    }
                }
                attributeValuesById.put(id,attributeValues);
            }
            entity.setAttributeValuesById(attributeValuesById);
            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
