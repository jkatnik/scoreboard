package com.sportradar.scoreboard;

/**
 * Comparator that sorts matches by total score (home + away) and then by start time (most recent)
 */
final class ByScoreAndTimeMatchComparator implements MatchComparator {
  @Override
  public int compare(Game m1, Game m2) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }
}
