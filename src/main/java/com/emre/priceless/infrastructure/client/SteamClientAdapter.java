package com.emre.priceless.infrastructure.client;


import com.emre.priceless.domain.model.Game;
import com.emre.priceless.domain.port.GamePriceProviderPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SteamClientAdapter implements GamePriceProviderPort {

    @Override
    public List<Game> fetchGames() {
        // TODO: Steam API REST call
        // map to domain Game model
        return List.of(
                new Game("steam-1", "Elden Ring", 29.99, "steam"),
                new Game("steam-2", "Hades", 9.99, "steam")
        );
    }
}