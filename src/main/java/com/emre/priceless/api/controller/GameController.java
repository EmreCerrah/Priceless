package com.emre.priceless.api.controller;

import com.emre.model.Game;
import com.emre.priceless.infrastructure.persistence.GameEntity;
import com.emre.priceless.usecase.service.GameSyncService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/games")
public class GameController {

    private final GameSyncService service;

    public GameController(GameSyncService service) {
        this.service = service;
    }

    @GetMapping("/sync")
    public void sync() {
        service.getInfo();
    }

    @GetMapping
    public GameEntity getAll(@RequestParam(required = false) String id) {
        return service.getById(id);
    }
}