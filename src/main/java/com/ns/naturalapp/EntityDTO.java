package com.ns.naturalapp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class EntityDTO {

    private String name;
    private List<String> attributeTitles;
    private Map<Long, List<Object>> attributeValuesById;

}
