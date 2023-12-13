package com.sportradar.scoreboard;

/**
 * Comparator that sorts matches by total score (home + away) and then by start time (most recent first).
 */
final class ByScoreAndTimeMatchComparator implements MatchComparator {
  @Override
  public int compare(Game m1, Game m2) {
    int scoreCompare = compareScore(m1, m2);

    if (scoreCompare != 0) {
      return scoreCompare;
    }
    return Long.compare(m1.startTime(), m2.startTime());
  }

  private int compareScore(Game m1, Game m2) {
    int totalScore1 = m1.homeScore() + m1.awayScore();
    int totalScore2 = m2.homeScore() + m2.awayScore();
    return Integer.compare(totalScore1, totalScore2);
  }
}
