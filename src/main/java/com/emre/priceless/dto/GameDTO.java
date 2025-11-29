package com.emre.priceless.dto;

import java.util.List;

public record GameDTO (
    String title,
    String description,
    List<PriceDTO> prices)
{}
