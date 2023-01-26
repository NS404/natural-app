package com.ns.naturalapp;

import com.ns.naturalapp.config.Attribute;
import com.ns.naturalapp.config.Conditions;
import com.ns.naturalapp.config.View;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class Query {

    private View view;
    private List<Attribute> attributes;
    private Conditions condition;
    private String queryString;

    public Query(View view) {
        this.view = view;
        this.attributes = view.getAttributes();
        this.condition = view.getCondition();
        this.queryString = "SELECT " + getColumns() + " FROM " + getTable() + " WHERE " + getCondition();
    }

    private String getTable() {
        return this.view.toString();
    }
    private String getColumns() {
        return this.attributes.stream()
                .map(Attribute::toString)
                .collect(Collectors.joining(", "));
    }
    private String getCondition() {
        return this.condition.getAttribute().toString() +
                this.condition.getOperator() + this.condition.getValue();
    }

    public List<String> getColumnNamesAsList() {
        List<String> columnNames = new ArrayList<>();

        for (Attribute a :
                this.attributes) {
            columnNames.add(a.getName());
        }
        return columnNames;
    }
}
