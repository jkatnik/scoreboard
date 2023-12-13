package com.sportradar.scoreboard;

import java.time.Clock;

public class ScoreboardFactory {
  public static Scoreboard createSortedScoreboard(MatchComparator comparator) {
    return new SortableScoreboard(comparator, Clock.systemDefaultZone());
  }

  public static Scoreboard createDefaultSortedScoreboard() {
    return createSortedScoreboard(new ByScoreAndTimeMatchComparator());
  }

  /**
   * According to the Clean Code (Robert C. Martin) the code should be testable, thus adding dedicated
   * method for testing is justified.
   */
  static Scoreboard createDefaultSortedScoreboard(Clock clock) {
    return new SortableScoreboard(new ByScoreAndTimeMatchComparator(), clock);
  }
}
