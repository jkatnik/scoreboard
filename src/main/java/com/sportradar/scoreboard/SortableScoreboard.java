package com.sportradar.scoreboard;

import java.time.Clock;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class SortableScoreboard implements Scoreboard {
  private final ConcurrentMap<String, Game> games = new ConcurrentHashMap<>();
  private final Comparator<Game> matchComparator;
  private final Clock clock;

  SortableScoreboard(Comparator<Game> matchComparator, Clock clock) {
    this.matchComparator = matchComparator;
    this.clock = clock;
  }

  @Override
  public void startGame(String homeTeam, String awayTeam) {
    validateTeamNames(homeTeam, awayTeam);

    Game game = new Game(homeTeam, awayTeam, clock.instant().toEpochMilli());
    games.put(game.getKey(), game);
  }

  @Override
  public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
    validateTeamNames(homeTeam, awayTeam);

    String key = Game.getKey(homeTeam, awayTeam);
    Game existingGame = games.get(key);
    if (existingGame == null) {
      throw new IllegalArgumentException("Match not found for teams: " + homeTeam + " vs " + awayTeam + ".");
    }

    games.put(key, existingGame.updateScore(homeScore, awayScore));
  }

  @Override
  public void finishGame(String homeTeam, String awayTeam) {
    validateTeamNames(homeTeam, awayTeam);

    games.remove(Game.getKey(homeTeam, awayTeam));
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
