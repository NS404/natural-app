package com.ns.naturalapp.Service;

import com.ns.naturalapp.DTO.EntityDTO;
import com.ns.naturalapp.DTO.Query;
import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
import com.ns.naturalapp.DTO.QueryServiceInterface;
import com.ns.naturalapp.Repository.AttributeRepo;
import com.ns.naturalapp.Repository.ConditionsRepo;
import com.ns.naturalapp.Repository.JDBCEntityRepository;
import com.ns.naturalapp.Repository.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class QueryService implements QueryServiceInterface {
    private final String defaultLimit = "3";
    private final String defaultOffset = "0";

    private final ViewRepository viewRepo;
    private final AttributeRepo attributeRepo;
    private final ConditionsRepo conditionsRepo;
    private final JDBCEntityRepository entityRepo;

    public EntityDTO getView(String name, String limit, String offset){

        if(limit == null || limit == ""){
             limit = defaultLimit;
        }
        if(offset == null || offset == ""){
            offset = defaultOffset;
        }
        View view = viewRepo.findViewByName(name);
        List<Attribute> attributes = attributeRepo.findAttributesByView(view);
        Conditions condition = conditionsRepo.findConditionsByView(view);
        Query query = new Query(view, attributes, condition, limit, offset);
        return entityRepo.getEntity(query);
    }
}
