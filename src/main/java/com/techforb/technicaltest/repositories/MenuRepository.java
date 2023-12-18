package com.techforb.technicaltest.repositories;

import com.techforb.technicaltest.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
