package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ByScoreAndTimeMatchComparatorTest {
  private MatchComparator comparator = new ByScoreAndTimeMatchComparator();
  private static long MOMENT_IN_TIME = 100;

  @Test
  void shouldSortByScore() {
    // given
    Game game1 = new Game("Home", "Away", 2, 0, MOMENT_IN_TIME);
    Game game2 = new Game("Home2", "Away2", 0, 1, MOMENT_IN_TIME);

    // when
    int result = comparator.compare(game1, game2);
    // then
    assertThat(result).isLessThan(0);
  }

  @Test
  void shouldSortByScoreAndTime() throws InterruptedException {
    // given
    Game game1 = new Game("Home", "Away", 2, 0, MOMENT_IN_TIME);
    Game game2 = new Game("Home2", "Away2", 2, 0, MOMENT_IN_TIME + 1); // this is more recent game

    // when
    int result = comparator.compare(game1, game2);

    // then
    assertThat(result).isGreaterThan(0);
  }
}
