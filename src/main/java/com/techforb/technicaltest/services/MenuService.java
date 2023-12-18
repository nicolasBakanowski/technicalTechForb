package com.techforb.technicaltest.services;

import com.techforb.technicaltest.models.Menu;
import com.techforb.technicaltest.repositories.MenuRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenuOptions() {
        return menuRepository.findAll();
    }
}
