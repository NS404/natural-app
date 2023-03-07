package com.ns.naturalapp.Repository;

import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepo extends JpaRepository<Attribute, Long> {

    List<Attribute> findAttributesByView(View view);
}
