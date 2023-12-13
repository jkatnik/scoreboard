package com.sportradar.scoreboard;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

  public static final Offset<Long> SMALL_TIME_OFFSET = Offset.offset(100L);

  @Test
  void shouldCreateGame() {
    // when
    Game game = new Game("Home", "Away");

    // then
    assertThat(game.homeTeam()).isEqualTo("Home");
    assertThat(game.awayTeam()).isEqualTo("Away");
    assertThat(game.homeScore()).isEqualTo(0);
    assertThat(game.awayScore()).isEqualTo(0);
    assertThat(game.startTime()).isCloseTo(System.currentTimeMillis(), SMALL_TIME_OFFSET);
  }

  @CsvSource({
    "1, 0",
    "0, 1",
  })
  void shouldUpdateScore(int homeScore, int awayScore) {
    // given
    var game = new Game("Home", "Away");

    // when
    var updatedGame = game.updateScore(homeScore, awayScore);

    // then
    assertThat(updatedGame.homeScore()).isEqualTo(homeScore);
    assertThat(updatedGame.awayScore()).isEqualTo(awayScore);
  }

  @Test
  void shouldGetKey() {
    var game = new Game("Home", "Away");
    assertThat(game.getKey()).isEqualTo("Home-Away");
  }
}
