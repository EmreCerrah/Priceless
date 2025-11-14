package com.emre.priceless.domain.port;

import com.emre.priceless.domain.model.Game;

import java.util.List;

public interface GamePriceProviderPort {
    List<Game> fetchGames();
}
