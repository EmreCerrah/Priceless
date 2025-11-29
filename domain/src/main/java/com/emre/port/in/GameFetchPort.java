package com.emre.port.in;


import com.emre.model.Game;

import java.util.List;

public interface GameFetchPort {
    List<Game> fetchGames();
}
