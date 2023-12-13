package com.sportradar.scoreboard;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class SortableScoreboard implements Scoreboard {
  private final ConcurrentMap<String, Game> games = new ConcurrentHashMap<>();
  private final Comparator<Game> matchComparator;

  SortableScoreboard(Comparator<Game> matchComparator) {
    this.matchComparator = matchComparator;
  }

  @Override
  public void startGame(String homeTeam, String awayTeam) {
    validateTeamNames(homeTeam, awayTeam);

    Game game = new Game(homeTeam, awayTeam);
    games.put(game.getKey(), game);
  }

  @Override
  public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public void finishGame(String homeTeam, String awayTeam) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  public List<Game> getSummary() {
    return games.values().stream()
      .sorted(matchComparator)
      .toList();
  }

  private void validateTeamNames(String homeTeam, String awayTeam) {
    if (homeTeam.equals(awayTeam)) {
      throw new IllegalArgumentException("Home and away team names must be different.");
    }

    if (homeTeam.isEmpty()) {
      throw new IllegalArgumentException("Home team name must not be empty.");
    }

    if (awayTeam.isEmpty()) {
      throw new IllegalArgumentException("Away team name must not be empty.");
    }
  }
}
