package com.emre.usecase.upsert;

import com.emre.model.Game;
import com.emre.port.out.GameRepositoryPort;
import com.emre.usecase.merge.GameMerger;

/**
 * Handles upsert semantics for Game aggregate by delegating merge rules
 * to {@link GameMerger} and persistence to {@link GameRepositoryPort}.
 */
public class GameUpserter {
    private final GameRepositoryPort repositoryPort;
    private final GameMerger merger;

    public GameUpserter(GameRepositoryPort repositoryPort, GameMerger merger) {
        this.repositoryPort = repositoryPort;
        this.merger = merger;
    }

    public void upsert(Game incoming) {
        Game existing = repositoryPort.getById(incoming.id().uuid());
        Game toPersist = existing == null ? incoming : merger.merge(existing, incoming);
        repositoryPort.save(toPersist);
    }
}
