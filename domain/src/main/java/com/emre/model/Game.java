package com.emre.model;

import com.emre.valueObject.GameId;

import java.util.List;

public record Game(GameId id,
                   String title,
                   String description,
                   List<StorePrice> storePrices
                   ) {
    public Game(String title, String description, List<StorePrice> storePrices) {
        this(new GameId(java.util.UUID.randomUUID()), title, description, storePrices);
    }
}

