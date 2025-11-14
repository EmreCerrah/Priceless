package com.emre.priceless.infrastructure.db;

import com.emre.priceless.domain.model.Game;
import com.emre.priceless.domain.port.GameRepositoryPort;
import com.emre.priceless.infrastructure.persistence.GameEntity;
import com.emre.priceless.infrastructure.persistence.GameJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameRepositoryAdapter implements GameRepositoryPort {

    private final GameJpaRepository repo;

    public GameRepositoryAdapter(GameJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public void saveAll(List<Game> games) {
        List<GameEntity> entities = games.stream()
                .map(g -> new GameEntity(g.getId(), g.getTitle(), g.getPrice(), g.getSource()))
                .toList();
        repo.saveAll(entities);
    }

    @Override
    public void save(Game game) {
        GameEntity e = new GameEntity(game.getId(), game.getTitle(), game.getPrice(), game.getSource());
        repo.save(e);
    }

    @Override
    public void update(Game game) {
        // Basit senaryo: save aynı zamanda update yapar (JPA upsert).
        GameEntity e = new GameEntity(game.getId(), game.getTitle(), game.getPrice(), game.getSource());
        repo.save(e);
    }

    @Override
    public List<Game> findAll() {
        return repo.findAll()
                .stream()
                .map(e -> new Game(e.getId(), e.getTitle(), e.getPrice(), e.getSource()))
                .toList();
    }
}
