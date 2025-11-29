package com.emre.priceless.infrastructure.persistence;

import com.emre.model.StorePrice;
import com.emre.valueObject.StorePriceId;
import jakarta.persistence.*;

@Entity
@Table(name = "store_prices")
public class StorePriceEntity {
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GameEntity game;

    private String storeId;
    private String externalId;
    private Double salePrice;
    private Double basePrice;
    private String currency;

    public StorePriceEntity() {}

    public StorePriceEntity(String id,
                            GameEntity game,
                            String storeId,
                            String externalId,
                            Double salePrice,
                            Double basePrice,
                            String currency) {
        this.id = id;
        this.game = game;
        this.storeId = storeId;
        this.externalId = externalId;
        this.salePrice = salePrice;
        this.basePrice = basePrice;
        this.currency = currency;
    }

    public static StorePriceEntity fromDomain(StorePrice price, GameEntity game) {
        String id = price.id() != null ? price.id().toString() : new StorePriceId().toString();
        return new StorePriceEntity(id, game, price.storeId(), price.externalId(), price.salePrice(), price.basePrice(), price.currency());
    }

    public StorePrice toDomain() {
        return new StorePrice(new StorePriceId(java.util.UUID.fromString(this.id)), this.storeId, this.externalId, this.salePrice, this.basePrice, this.currency);
    }

    public String getId() { return id; }
    public GameEntity getGame() { return game; }
    public String getStoreId() { return storeId; }
    public String getExternalId() { return externalId; }
    public Double getSalePrice() { return salePrice; }
    public Double getBasePrice() { return basePrice; }
    public String getCurrency() { return currency; }
}
