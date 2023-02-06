package com.ns.naturalapp.repo;

import com.ns.naturalapp.config.Attribute;
import com.ns.naturalapp.config.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepo extends JpaRepository<Attribute, Long> {

    List<Attribute> findAttributesByView(View view);
}
