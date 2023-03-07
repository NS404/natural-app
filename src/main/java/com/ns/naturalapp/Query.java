package com.ns.naturalapp;

import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
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

    public Query(View view, List<Attribute> attributes, Conditions condition) {
        this.view = view;
        this.attributes = attributes;
        this.condition = condition;
        this.queryString = "SELECT " + getColumns() + " FROM " + getTable() + getCondition();
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
        if(condition != null)
            return " WHERE " + condition.getConditionString();
        else
            return "";
    }

    public List<String> getColumnNamesAsList() {
        List<String> columnNames = new ArrayList<>();

        for (Attribute a : this.attributes) {
            columnNames.add(a.getName());
        }
        return columnNames;
    }
    public Attribute getAttribute(String columnName) {
        for (Attribute attribute : attributes) {
            if (attribute.getName().equals(columnName)) {
                return attribute;
            }
        }
        return null;
    }
}
