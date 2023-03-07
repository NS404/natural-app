package com.ns.naturalapp.Repository;

import com.ns.naturalapp.Config.View;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewRepository extends JpaRepository<View, Long> {

    View findViewByName(String name);

}
