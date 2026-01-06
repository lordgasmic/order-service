package com.lordgasmic.orderingservice.mappers;

import com.lordgasmic.orderingservice.entities.MenuEntity;
import com.lordgasmic.orderingservice.entities.MenuExtrasEntity;
import com.lordgasmic.orderingservice.models.MenuResponse;

public class MenuWrapper {

    public static MenuResponse toMenuResponse(MenuEntity entity) {
        MenuResponse response = new MenuResponse();
        response.setOption(entity.getItem());
        response.setExtras(entity.getExtras().stream().map(MenuExtrasEntity::getExtra).toList());
        return response;
    }
}
