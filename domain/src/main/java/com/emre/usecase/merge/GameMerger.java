package com.emre.usecase.merge;

import com.emre.model.Game;

/**
 * Defines how to merge an existing Game with an incoming Game snapshot.
 */
public interface GameMerger {
    Game merge(Game existing, Game incoming);
}
