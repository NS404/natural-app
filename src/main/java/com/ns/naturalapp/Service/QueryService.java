package com.ns.naturalapp.Service;

import com.ns.naturalapp.DTO.EntityDTO;
import com.ns.naturalapp.DTO.Query;
import com.ns.naturalapp.DTO.QueryServiceInterface;
import com.ns.naturalapp.NaturalAppApplication;
import com.ns.naturalapp.Repository.JDBCEntityRepository;
import lombok.RequiredArgsConstructor;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class QueryService implements QueryServiceInterface {
    private final String defaultLimit = "3";
    private final String defaultOffset = "0";
    private final JDBCEntityRepository entityRepo;

    public EntityDTO getView(String name, String limit, String offset, String[] requestConditions) {

        if (limit == null || limit == "") {
            limit = defaultLimit;
        }
        if (offset == null || offset == "") {
            offset = defaultOffset;
        }

        Query query = new Query(NaturalAppApplication.initMap.get(name).getView(), NaturalAppApplication.initMap.get(name).getAttributes(), NaturalAppApplication.initMap.get(name).getCondition(), limit, offset, requestConditions);
        return entityRepo.getEntity(query);
    }

    public String[] parseConditions(String requestConditions) {
        if (requestConditions == "" || requestConditions == null) {
            String[] empty = {};
            return empty;
        }
        String regex = ",";
        String[] conditions = requestConditions.split(regex);
        return conditions;
    }
}