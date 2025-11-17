package com.emre.model;

import java.util.List;

public record Game(GameId id,
                   String title,
                   String discription,
                   List<StorePrice> storePrices
                   ) {
    public Game(String title, String discription, List<StorePrice> storePrices) {
        this(new GameId(java.util.UUID.randomUUID()), title, discription, storePrices);
    }
}

