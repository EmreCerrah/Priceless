package com.emre.port.out;


import com.emre.model.Game;

import java.util.List;
import java.util.UUID;

public interface GameRepositoryPort {
    void saveAll(List<Game> games);
    Game getById(UUID id);
    void save(Game game);
    void update(Game game);
    List<Game> findAll();
}
