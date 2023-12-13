package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreboardFactoryTest {

  @Test
  void shouldCreateDefaultSortedScoreboard() {
    // when
    Scoreboard scoreboard = ScoreboardFactory.createDefaultSortedScoreboard();

    // then
    assertThat(scoreboard).isInstanceOf(SortableScoreboard.class);
  }
}
