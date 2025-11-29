package com.emre.model;

import com.emre.valueObject.StorePriceId;

public record StorePrice(
        StorePriceId id,
        String storeId,
        String externalId,
        Double salePrice,
        Double basePrice,
        String currency
) {
    public StorePrice(String storeId,
                      String externalId,
                      Double salePrice,
                      Double basePrice,
                      String currency) {
        this(new com.emre.valueObject.StorePriceId(), storeId, externalId, salePrice, basePrice, currency);
    }
}
