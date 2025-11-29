package com.emre.priceless.api.controller;

import com.emre.priceless.dto.GameDTO;
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
    public GameDTO getAll(@RequestParam(required = false) String id) {
        return service.getById(id);
    }
}