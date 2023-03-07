package com.ns.naturalapp.Repository;

import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionsRepo extends JpaRepository<Conditions, Long> {

    Conditions findConditionsByView(View view);
}
