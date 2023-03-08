package com.ns.naturalapp.Service;

import com.ns.naturalapp.DTO.EntityDTO;
import com.ns.naturalapp.DTO.Query;
import com.ns.naturalapp.DTO.QueryServiceInterface;
import com.ns.naturalapp.NaturalAppApplication;
import com.ns.naturalapp.Repository.JDBCEntityRepository;
import lombok.RequiredArgsConstructor;

import static com.ns.naturalapp.NaturalAppApplication.initMap;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class QueryService implements QueryServiceInterface {
    private final String defaultLimit = "3";
    private final String defaultOffset = "0";
    private final JDBCEntityRepository entityRepo;

    public EntityDTO getView(String name, String limit, String offset, String requestConditions) {

        if (limit == null || limit == "") {
            limit = defaultLimit;
        }
        if (offset == null || offset == "") {
            offset = defaultOffset;
        }
        Query query;

        if (requestConditions == "" || requestConditions == null) {
            query = new Query(initMap.get(name).getView(),
                    initMap.get(name).getAttributes(),
                    initMap.get(name).getCondition(),
                    limit, offset);
        }else {
            query = new Query(initMap.get(name).getView(),
                    initMap.get(name).getAttributes(),
                    requestConditions,limit,offset);
        }

        return entityRepo.getEntity(query);
    }


}