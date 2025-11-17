package com.emre.model;

public record StorePrice(String storeId,
                         String externalId,
                         Double salePrice,
                         Double basePrice,
                         String currency) {
}
