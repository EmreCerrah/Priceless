package com.emre.priceless.usecase.service;

import com.emre.model.Game;
import com.emre.priceless.dto.GameDTO;
import com.emre.priceless.usecase.mapper.GameDtoMapper;
import com.emre.port.in.GameFetchPort;
import com.emre.port.out.GameRepositoryPort;
import com.emre.usecase.GameDomainService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

@Service
public class GameSyncService {

    private final GameDomainService domainService;
    private final GameDtoMapper mapper;

    public GameSyncService(List<GameFetchPort> providers,
                           GameRepositoryPort repository,
                           GameDtoMapper mapper) {
        this.domainService = new GameDomainService(providers, repository);
        this.mapper = mapper;
    }

    public void getInfo() {
        domainService.sync();
    }

    public GameDTO getById(String id) {
        Game game = domainService.getById(UUID.fromString(id));
        return mapper.toDto(game);
    }
}
