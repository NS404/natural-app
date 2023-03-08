package com.ns.naturalapp;


import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
import com.ns.naturalapp.DTO.QueryElements;
import com.ns.naturalapp.Repository.AttributeRepo;
import com.ns.naturalapp.Repository.ConditionsRepo;
import com.ns.naturalapp.Repository.JDBCEntityRepository;
import com.ns.naturalapp.Repository.ViewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class NaturalAppApplication  {

    private final ViewRepository viewRepo;
    private final AttributeRepo attributeRepo;
    private final ConditionsRepo conditionsRepo;
    public static Map<String, QueryElements> initMap;

    public NaturalAppApplication(ViewRepository viewRepo, AttributeRepo attributeRepo, ConditionsRepo conditionsRepo) {
        this.viewRepo = viewRepo;
        this.attributeRepo = attributeRepo;
        this.conditionsRepo = conditionsRepo;
        initMap = new HashMap<>();
    }

    public static void main(String[] args) {
        SpringApplication.run(NaturalAppApplication.class, args);
        System.out.println(Collections.singletonList(initMap));
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            List<View> views = viewRepo.findAll();
            views.forEach(view -> {
                List<Attribute> attributes = attributeRepo.findAttributesByView(view);
                Conditions condition = conditionsRepo.findConditionsByView(view);
                initMap.put(view.getName(), new QueryElements(view, attributes, condition));
            });
            for (String arg : args) {
                System.out.println(arg);
            }
        };
    }
}