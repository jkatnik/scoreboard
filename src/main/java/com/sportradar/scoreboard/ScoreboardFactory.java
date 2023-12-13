package com.sportradar.scoreboard;

public class ScoreboardFactory {
  public static Scoreboard createSortedScoreboard(MatchComparator comparator) {
    return new SortableScoreboard(comparator);
  }

  public static Scoreboard createDefaultSortedScoreboard() {
    return createSortedScoreboard(new ByScoreAndTimeMatchComparator());
  }
}
