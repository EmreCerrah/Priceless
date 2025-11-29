package com.emre.priceless.infrastructure.db;

import com.emre.model.Game;
import com.emre.port.out.GameRepositoryPort;
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

    }

    @Override
    public void save(Game game) {
        repo.save(GameEntity.toDomain(game));
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public List<Game> findAll() {
        return List.of();
    }
    public GameEntity getById(String id){
        return repo.findById(id).orElse(null);
    }
}
