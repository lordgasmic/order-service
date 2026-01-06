package com.lordgasmic.orderingservice.service;

import com.lordgasmic.orderingservice.entities.MenuEntity;
import com.lordgasmic.orderingservice.mappers.MenuWrapper;
import com.lordgasmic.orderingservice.models.MenuResponse;
import com.lordgasmic.orderingservice.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuResponse> getMenu() {
        Iterable<MenuEntity> entities = menuRepository.findAll();

        List<MenuResponse> response = new ArrayList<>();
        for(MenuEntity entity:entities) {
            response.add(MenuWrapper.toMenuResponse(entity));
        }

        return response;
    }
}
