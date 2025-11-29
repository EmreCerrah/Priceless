package com.emre.priceless.usecase.service;

import com.emre.model.Game;
import com.emre.priceless.infrastructure.client.EpicGameClient;
import com.emre.priceless.infrastructure.db.GameRepositoryAdapter;
import com.emre.priceless.infrastructure.persistence.GameEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSyncService {

    private final EpicGameClient provider;
    private final GameRepositoryAdapter repository;

    public GameSyncService(EpicGameClient provider,
                           GameRepositoryAdapter repository) {
        this.provider = provider;
        this.repository = repository;
    }

    public void getInfo() {
        List<Game> externalGames = provider.fetchGames();
        for (Game external : externalGames) {
                repository.save(external);
        }
    }

    public GameEntity getById(String id) {
        return repository.getById(id);
    }
}
