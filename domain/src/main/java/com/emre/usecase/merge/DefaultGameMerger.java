package com.emre.usecase.merge;

import com.emre.model.Game;
import com.emre.model.StorePrice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefaultGameMerger implements GameMerger {

    @Override
    public Game merge(Game existing, Game incoming) {
        if (existing == null) {
            return incoming;
        }
        List<StorePrice> mergedPrices = mergePricesByStore(existing.storePrices(), incoming.storePrices());
        String title = incoming.title() != null ? incoming.title() : existing.title();
        String description = incoming.description() != null ? incoming.description() : existing.description();
        return new Game(existing.id(), title, description, mergedPrices);
    }

    private List<StorePrice> mergePricesByStore(List<StorePrice> base, List<StorePrice> updates) {
        Map<String, StorePrice> byStore = new LinkedHashMap<>();
        if (base != null) {
            for (StorePrice p : base) {
                if (p != null && p.storeId() != null) {
                    byStore.put(p.storeId(), p);
                }
            }
        }
        if (updates != null) {
            for (StorePrice p : updates) {
                if (p != null && p.storeId() != null) {
                    // Replace existing provider price or add new provider price
                    byStore.put(p.storeId(), p);
                }
            }
        }
        return new ArrayList<>(byStore.values());
    }
}
