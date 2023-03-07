package com.ns.naturalapp.Repository;

import com.ns.naturalapp.Config.Conditions;
import com.ns.naturalapp.Config.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConditionsRepo extends JpaRepository<Conditions, Long> {

    Conditions findConditionsByView(View view);
}
