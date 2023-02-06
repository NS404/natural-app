package com.ns.naturalapp;

import com.ns.naturalapp.config.Attribute;
import com.ns.naturalapp.config.Conditions;
import com.ns.naturalapp.config.View;
import com.ns.naturalapp.repo.AttributeRepo;
import com.ns.naturalapp.repo.ConditionsRepo;
import com.ns.naturalapp.repo.JDBCEntityRepository;
import com.ns.naturalapp.repo.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final ViewRepository viewRepo;
    private final AttributeRepo attributeRepo;
    private final ConditionsRepo conditionsRepo;
    private final JDBCEntityRepository entityRepo;


    public EntityDTO getView(String name){

        View view = viewRepo.findViewByName(name);
        List<Attribute> attributes = attributeRepo.findAttributesByView(view);
        Conditions condition = conditionsRepo.findConditionsByView(view);
        Query query = new Query(view, attributes, condition);
        return entityRepo.getEntity(query);

    }










}
