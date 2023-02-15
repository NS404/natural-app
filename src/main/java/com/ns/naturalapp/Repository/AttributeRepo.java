package com.ns.naturalapp.Repository;

import com.ns.naturalapp.Config.Attribute;
import com.ns.naturalapp.Config.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributeRepo extends JpaRepository<Attribute, Long> {

    //@Query(value = "Select * From `attribute` limit 2", nativeQuery = true)
    List<Attribute> findAttributesByView(View view);
}
