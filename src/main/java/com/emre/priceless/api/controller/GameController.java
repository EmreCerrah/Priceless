package com.emre.priceless.api.controller;

import com.emre.priceless.domain.model.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameSyncService service;

    public GameController(GameSyncService service) {
        this.service = service;
    }

    @PostMapping("/sync")
    public void sync() {
        service.sync();
    }

    @GetMapping
    public List<Game> getAll() {
        return service.getAll();
    }
}