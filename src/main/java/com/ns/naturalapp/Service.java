package com.ns.naturalapp;

import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
import com.ns.naturalapp.Repository.AttributeRepo;
import com.ns.naturalapp.Repository.ConditionsRepo;
import com.ns.naturalapp.Repository.JDBCEntityRepository;
import com.ns.naturalapp.Repository.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

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


    public List<View> getAllViews() {
        return viewRepo.findAll();
    }
}
