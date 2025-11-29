package com.emre.priceless.infrastructure.persistence;

import com.emre.model.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class GameEntity {
    @Id
    private String id;
    private String title;
    private String description;
    private String source;

    public GameEntity() {
    }
    public GameEntity(String id, String title, String description, String source) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.source = source;
    }
    public static GameEntity toDomain(Game game) {
        return new GameEntity(game.id().toString(), game.title(), game.description(), game.storePrices().toString());
    }
}