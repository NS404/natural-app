package com.ns.naturalapp.DTO;

import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QueryElements {
    private View view;
    private List<Attribute> attributes;
    private Conditions condition;
}
