package com.emre.priceless.domain.service;

import com.emre.priceless.domain.model.Game;

public class GameDomainService {

    public boolean hasPriceChanged(Game oldG, Game newG) {
        return oldG.getPrice() != newG.getPrice();
    }

    public Game merge(Game oldG, Game newG) {
        oldG.setPrice(newG.getPrice());
        return oldG;
    }
}