package com.ns.naturalapp.repo;

import com.ns.naturalapp.config.Conditions;
import com.ns.naturalapp.config.View;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionsRepo extends JpaRepository<Conditions, Long> {

    Conditions findConditionsByView(View view);
}
