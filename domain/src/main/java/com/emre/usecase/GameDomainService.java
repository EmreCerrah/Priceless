package com.emre.usecase;

import com.emre.model.Game;
import com.emre.port.in.GameFetchPort;
import com.emre.port.out.GameRepositoryPort;
import com.emre.usecase.merge.DefaultGameMerger;
import com.emre.usecase.merge.GameMerger;
import com.emre.usecase.upsert.GameUpserter;

import java.util.List;
import java.util.UUID;

public class GameDomainService {
    private final List<GameFetchPort> fetchPorts;
    private final GameRepositoryPort repositoryPort;
    private final GameUpserter upserter;


    public GameDomainService(List<GameFetchPort> fetchPorts, GameRepositoryPort repositoryPort) {
        this.fetchPorts = fetchPorts;
        this.repositoryPort = repositoryPort;
        // Compose default collaborators adhering to SOLID (SRP + DIP)
        GameMerger merger = new DefaultGameMerger();
        this.upserter = new GameUpserter(repositoryPort, merger);
    }

    public void sync() {
        // For each provider (strategy), fetch games and upsert using dedicated upserter
        for (GameFetchPort port : fetchPorts) {
            List<Game> incomingGames = port.fetchGames();
            for (Game incoming : incomingGames) {
                upserter.upsert(incoming);
            }
        }
    }
    public Game getById (UUID id){
        return repositoryPort.getById(id);
    }
}
