package com.emre.priceless.infrastructure.client;


import com.emre.model.Game;
import com.emre.port.in.GameFetchPort;
import com.emre.valueObject.GameId;
import com.emre.model.StorePrice;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class SteamClientAdapter implements GameFetchPort {

    @Override
    public List<Game> fetchGames() {
        // TODO: Steam API REST call
        // map to domain Game model
        List<StorePrice> storePricesGame1 = List.of(new StorePrice("steam",
                "steamId", 100.0, 100.0, "usd"),
                new StorePrice("epic",
                        "epicId", 90.0, 100.0, "usd"));

        List<StorePrice> storePricesGame2 = List.of(new StorePrice("steam",
                        "steamId2", 70.0, 70.0, "usd"),
                new StorePrice("epic",
                        "epicId2", 70.0, 70.0, "usd"));

        return List.of(
                new Game(new GameId(), "Elden Ring", "Oh elden ring", storePricesGame1),
                new Game(new GameId(), "Hades", "hades", storePricesGame2)
        );
    }
}