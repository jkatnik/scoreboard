package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static com.sportradar.scoreboard.ScoreboardAssembler.givenGame;
import static org.assertj.core.api.Assertions.assertThat;

class ByScoreAndTimeMatchComparatorTest {
  private MatchComparator comparator = new ByScoreAndTimeMatchComparator();

  @Test
  void shouldSortByScore() {
    // given
    Game game1 = givenGame("Home", "Away", 2, 0);
    Game game2 = givenGame("Home2", "Away2", 0, 1);

    // when
    int result = comparator.compare(game1, game2);
    // then
    assertThat(result).isLessThan(0);
  }

  @Test
  void shouldSortByScoreAndTime() throws InterruptedException {
    // given
    Game game1 = givenGame("Home", "Away", 2, 0);
    Thread.sleep(1);
    Game game2 = givenGame("Home2", "Away2", 2, 0); // this is more recent game

    // when
    int result = comparator.compare(game1, game2);
    // then
    assertThat(result).isLessThan(0);
  }
}
