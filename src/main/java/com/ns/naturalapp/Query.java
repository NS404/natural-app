package com.ns.naturalapp;

import com.ns.naturalapp.config.Attribute;
import com.ns.naturalapp.config.Condition;
import com.ns.naturalapp.config.View;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class Query {

    private View view;
    private List<Attribute> attributes;
    private Condition condition;
    private String queryString;

    public Query(View view, List<Attribute> attributes, Condition condition) {
        this.view = view;
        this.attributes = attributes;
        this.condition = condition;
        this.queryString = "SELECT " + getColumns() + " FROM " + getTable() + " WHERE " + getCondition();
    }

    private String getTable() {
        return this.view.toString();
    }
    private String getColumns() {
        return this.attributes.stream()
                .map(Attribute::toString)
                .collect(Collectors.joining(" "));
    }
    private String getCondition() {
        return this.condition.getAttribute().toString() +
                this.condition.getOperator() + this.condition.getValue();
    }
}
