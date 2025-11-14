package com.emre.priceless.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class GameEntity {
    @Id
    private String id;
    private String title;
    private Double price;
    private String source;

    public GameEntity() {
    }
    public GameEntity(String id, String title, Double price, String source) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.source = source;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    @Override
    public String toString() {
        return "GameEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", source='" + source + '\'' +
                '}';
    }
}