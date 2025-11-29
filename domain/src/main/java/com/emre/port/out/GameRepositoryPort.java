package com.emre.port.out;


import com.emre.model.Game;

import java.util.List;

public interface GameRepositoryPort {
    void saveAll(List<Game> games);
    void save(Game game);
    void update(Game game);
    List<Game> findAll();
}
