package com.ns.naturalapp.Service;

import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
import com.ns.naturalapp.DTO.QueryElements;
import com.ns.naturalapp.Repository.AttributeRepo;
import com.ns.naturalapp.Repository.ConditionsRepo;
import com.ns.naturalapp.Repository.JDBCEntityRepository;
import com.ns.naturalapp.Repository.ViewRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@org.springframework.stereotype.Service
public class RefreshService {
    public  static Map<String, QueryElements> init;
    private final ViewRepository viewRepo;
    private final AttributeRepo attributeRepo;
    private final ConditionsRepo conditionsRepo;
    private final JDBCEntityRepository entityRepo;

    public RefreshService(ViewRepository viewRepo, AttributeRepo attributeRepo, ConditionsRepo conditionsRepo, JDBCEntityRepository entityRepo, Map<String, QueryElements> init) {
        this.viewRepo = viewRepo;
        this.attributeRepo = attributeRepo;
        this.conditionsRepo = conditionsRepo;
        this.entityRepo = entityRepo;
        this.init = init;
    }
    public Map<String,QueryElements> refreshData( ){
            List<View> views = viewRepo.findAll();
            views.stream().forEach(view -> {
                List<Attribute> attributes = attributeRepo.findAttributesByView(view);
                Conditions condition = conditionsRepo.findConditionsByView(view);
                init.put(view.getName(), new QueryElements(view, attributes, condition));
            });
        return init;
     }
}

