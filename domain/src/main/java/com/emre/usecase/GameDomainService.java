package com.emre.usecase;

import com.emre.port.in.GameFetchPort;
import com.emre.port.out.GameRepositoryPort;

public class GameDomainService {
    private final GameFetchPort fetchPort;
    private final GameRepositoryPort repositoryPort;


    public GameDomainService(GameFetchPort fetchPort, GameRepositoryPort repositoryPort) {
        this.fetchPort = fetchPort;
        this.repositoryPort = repositoryPort;
    }

    public void sync() {
        // TODO: Business Logic
        fetchPort.fetchGames().forEach(repositoryPort::save);
    }
}
