package com.emre.valueObject;

import java.util.Objects;
import java.util.UUID;

public record StorePriceId(UUID id) {

    public StorePriceId() {
        this(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorePriceId that = (StorePriceId) o;
        return Objects.equals(id, that.id);
    }

}
