package com.emre.port;


import com.emre.model.Game;

import java.util.List;

public interface GamePriceProviderPort {
    List<Game> fetchGames();
}
