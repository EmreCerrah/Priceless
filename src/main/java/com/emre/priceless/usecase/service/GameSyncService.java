package com.emre.priceless.usecase.service;

import com.emre.priceless.domain.model.Game;
import com.emre.priceless.domain.port.GamePriceProviderPort;
import com.emre.priceless.domain.port.GameRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSyncService {

    private final GamePriceProviderPort provider;
    private final GameRepositoryPort repository;

    public GameSyncService(GamePriceProviderPort provider,
                           GameRepositoryPort repository) {
        this.provider = provider;
        this.repository = repository;
    }

    public void sync() {

        List<Game> externalGames = provider.fetchGames();
        List<Game> currentGames = repository.findAll();

        for (Game external : externalGames) {

            Game existing = currentGames.stream()
                    .filter(g -> g.getId().equals(external.getId()))
                    .findFirst()
                    .orElse(null);

            if (existing == null) {
                // yeni oyun → ekle
                repository.save(external);
                continue;
            }

            // fiyat değişmiş mi?
            if (existing.getPrice() != external.getPrice()) {
                existing.setPrice(external.getPrice());
                repository.update(existing);
            }
        }
    }

    public List<Game> getAll() {
        return repository.findAll();
    }
}
