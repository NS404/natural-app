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
    private Conditions conditions;
    private String queryString;

    public Query(View view, List<Attribute> attributes, Conditions conditions) {
        this.view = view;
        this.attributes = attributes;
        this.conditions = conditions;
        this.queryString = "SELECT " + getColumns() + " FROM " + getTable() + " WHERE " + getConditions();
    }

    private String getTable() {
        return this.view.toString();
    }
    private String getColumns() {
        return this.attributes.stream()
                .map(Attribute::toString)
                .collect(Collectors.joining(" "));
    }
    private String getConditions() {
        return this.conditions.getAttribute().toString() +
                this.conditions.getOperator() + this.conditions.getValue();
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
