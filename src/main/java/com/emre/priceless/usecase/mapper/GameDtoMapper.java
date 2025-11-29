package com.emre.priceless.usecase.mapper;

import com.emre.model.Game;
import com.emre.model.StorePrice;
import com.emre.priceless.dto.GameDTO;
import com.emre.priceless.dto.PriceDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameDtoMapper {

    public GameDTO toDto(Game game) {
        List<PriceDTO> prices = game.storePrices() == null ? List.of() :
                game.storePrices().stream()
                        .map(this::toDto)
                        .toList();
        return new GameDTO(game.title(), game.description(), prices);
    }

    public PriceDTO toDto(StorePrice p) {
        String pid = p.id() != null ? p.id().toString() : null;
        return new PriceDTO(pid, p.storeId(), p.externalId(), p.salePrice(), p.basePrice(), p.currency());
    }
}
