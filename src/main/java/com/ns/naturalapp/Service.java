package com.ns.naturalapp;

import com.ns.naturalapp.config.View;
import com.ns.naturalapp.repo.JDBCEntityRepository;
import com.ns.naturalapp.repo.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private List<View> views;
    private final ViewRepository viewRepo;
    private final JDBCEntityRepository entityRepo;


    public void getView(long viewId){
        Optional<View> optionalView = viewRepo.findById(viewId);

        if(optionalView.isPresent()){
            View view = optionalView.get();
            Query query = new Query(view, view.getAttributes(), view.getCondition());
            entityRepo.getEntity(query);
        }


    }










}
