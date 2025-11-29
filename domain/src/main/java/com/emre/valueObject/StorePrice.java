package com.emre.valueObject;

public record StorePrice(String storeId,
                         String externalId,
                         Double salePrice,
                         Double basePrice,
                         String currency) {
}
