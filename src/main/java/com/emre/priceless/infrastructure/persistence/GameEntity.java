package com.emre.priceless.infrastructure.persistence;

import com.emre.model.Game;
import com.emre.model.StorePrice;
import com.emre.valueObject.GameId;
import com.emre.valueObject.StorePriceId;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "games")
public class GameEntity {
    @Id
    private String id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<StorePriceEntity> prices = new ArrayList<>();

    public GameEntity() {
    }

    public GameEntity(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static GameEntity toEntity(Game game) {
        GameEntity entity = new GameEntity(game.id().toString(), game.title(), game.description());
        if (game.storePrices() != null) {
            List<StorePriceEntity> priceEntities = game.storePrices().stream()
                    .map(p -> StorePriceEntity.fromDomain(p, entity))
                    .collect(Collectors.toCollection(ArrayList::new));
            entity.prices.clear();
            entity.prices.addAll(priceEntities);
        }
        return entity;
    }

    public static Game toDomain(GameEntity entity) {
        List<StorePrice> prices = entity.prices == null ? List.of() : entity.prices.stream()
                .map(StorePriceEntity::toDomain)
                .toList();
        return new Game(new GameId(UUID.fromString(entity.getId())), entity.getTitle(), entity.getDescription(), prices);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<StorePriceEntity> getPrices() {
        return prices;
    }
}