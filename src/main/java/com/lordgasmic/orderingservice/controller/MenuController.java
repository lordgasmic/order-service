package com.lordgasmic.orderingservice.controller;

import com.lordgasmic.orderingservice.models.MenuResponse;
import com.lordgasmic.orderingservice.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(final MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/api/v1/menu")
    public ResponseEntity<List<MenuResponse>> getMenu() {
        return ResponseEntity.ok(menuService.getMenu());
    }
}
