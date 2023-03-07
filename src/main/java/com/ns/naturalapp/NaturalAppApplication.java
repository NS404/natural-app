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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class NaturalAppApplication  {

    private final ViewRepository viewRepo;
    private final AttributeRepo attributeRepo;
    private final ConditionsRepo conditionsRepo;
    private final JDBCEntityRepository entityRepo;
    public static Map<String, QueryElements> initMap;

    public NaturalAppApplication(ViewRepository viewRepo, AttributeRepo attributeRepo, ConditionsRepo conditionsRepo, JDBCEntityRepository entityRepo, Map<String, QueryElements> initMap) {
        this.viewRepo = viewRepo;
        this.attributeRepo = attributeRepo;
        this.conditionsRepo = conditionsRepo;
        this.entityRepo = entityRepo;
        this.initMap = initMap;
    }

    public static void main(String[] args) {
        SpringApplication.run(NaturalAppApplication.class, args);
        System.out.println(Arrays.asList(initMap));
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            List<View> views = viewRepo.findAll();
            views.stream().forEach(view -> {
                List<Attribute> attributes = attributeRepo.findAttributesByView(view);
                Conditions condition = conditionsRepo.findConditionsByView(view);
                initMap.put(view.getName(), new QueryElements(view, attributes, condition));
            });;
            for (String arg : args) {
                System.out.println(arg);
            }
        };
    }
}