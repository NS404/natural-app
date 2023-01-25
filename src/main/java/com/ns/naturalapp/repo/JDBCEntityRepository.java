package com.ns.naturalapp.repo;

import com.ns.naturalapp.Entity;
import com.ns.naturalapp.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JDBCEntityRepository {

    public void getEntity(Query query){

        String queryString = query.getQueryString();
        int colCount = query.getAttributes().size();
        Entity entity = new Entity();
        entity.setName(query.getView().getName());
        entity.setAttributeTitles(query.getColumnNamesAsList());
        Map<Long, List<String>> attributeValuesById = new HashMap<>();


        try(ResultSet resultSet = DatabaseConnection.selectAction(queryString)) {

            while(resultSet.next()) {






            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
