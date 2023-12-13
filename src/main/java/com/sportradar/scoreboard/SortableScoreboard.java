package com.sportradar.scoreboard;

import java.util.Comparator;
import java.util.List;

final class SortableScoreboard implements Scoreboard {
  private final Comparator<Game> matchComparator;

  SortableScoreboard(Comparator<Game> matchComparator) {
    this.matchComparator = matchComparator;
  }

  @Override
  public void startGame(String homeTeam, String awayTeam) {
    throw new UnsupportedOperationException("Not implemented yet.");
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
    throw new UnsupportedOperationException("Not implemented yet.");
  }
}
