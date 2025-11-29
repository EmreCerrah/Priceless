package com.emre.valueObject;

import java.util.UUID;

public record GameId (UUID uuid){
    public GameId (){
        this(UUID.randomUUID());
    }
}
