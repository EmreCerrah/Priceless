package com.emre.priceless.dto;

public record PriceDTO(
        String id,
        String storeId,
        String externalId,
        Double salePrice,
        Double basePrice,
        String currency
) {}
