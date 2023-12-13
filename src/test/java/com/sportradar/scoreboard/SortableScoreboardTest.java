package com.sportradar.scoreboard;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.sportradar.scoreboard.ScoreboardAssembler.given;
import static com.sportradar.scoreboard.ScoreboardAssembler.givenGame;
import static org.assertj.core.api.Assertions.*;

class SortableScoreboardTest {
  private Scoreboard scoreboard;

  @BeforeEach
  void setUp() {
    scoreboard = ScoreboardFactory.createDefaultSortedScoreboard();
  }

  @Test
  void testStartGame() {
    // given
    scoreboard.startGame("Home", "Away");

    // when
    assertThat(scoreboard.getSummary()).hasSize(1);

    // then
    assertThat(scoreboard.getSummary().getFirst())
      .has(teamAndScoresEqual(givenGame("Home", "Away", 0, 0)));
  }

  @Test
  void testUpdateScore() {
    // given
    scoreboard.startGame("Home", "Away");

    // when
    scoreboard.updateScore("Home", "Away", 1, 0);

    // then
    assertThat(scoreboard.getSummary()).hasSize(1);
    Game game = scoreboard.getSummary().getFirst();

    assertThat(game).has(teamAndScoresEqual(givenGame("Home", "Away", 1, 0)));
  }

  @Test
  void shouldUpdateCorrectGame() {
    // given
    given(scoreboard)
      .startGame("Home", "Away")
      .startGame("Home2", "Away2");

    // when
    scoreboard.updateScore("Home", "Away", 1, 0);

    // then
    assertThat(scoreboard.getSummary()).hasSize(2);

    assertThat(scoreboard.getSummary().getFirst())
      .has(teamAndScoresEqual(givenGame("Home", "Away", 1, 0)));

    assertThat(scoreboard.getSummary().get(1))
      .has(teamAndScoresEqual(givenGame("Home2", "Away2", 0, 0)));
  }

  @Test
  void shouldGamesBeSortedByTotalScoreAndStartTime() {
    // given
    given(scoreboard)
      .withGame("Home1", "Away1", 1, 0) // total score 1 - should be last
      .withGame("Home2", "Away2", 1, 1) // total score 2, started earlier - should be second
      .withGame("Home3", "Away3", 1, 1); // total score 2, started later - should be first

    // when
    var summary = scoreboard.getSummary();

    // then
    assertThat(summary)
      .extracting(Game::getKey)
      .containsExactly("Home3-Away3", "Home2-Away2", "Home1-Away1");
  }

  @Test
  void testFinishGame() {
    //given
    given(scoreboard)
      .withGame("Home1", "Away1", 1, 0)
      .withGame("Home2", "Away2", 1, 1)
      .withGame("Home3", "Away3", 1, 1);

    // when
    scoreboard.finishGame("Home2", "Away2");

    // then
    var summary = scoreboard.getSummary();
    assertThat(summary)
      .extracting(Game::getKey)
      .containsExactly("Home3-Away3", "Home1-Away1");
  }

  private static Condition<Game> teamAndScoresEqual(Game expectedGame) {
    return new Condition<>(actualGame ->
      actualGame.homeTeam().equals(expectedGame.homeTeam()) &&
        actualGame.awayTeam().equals(expectedGame.awayTeam()) &&
        actualGame.homeScore() == expectedGame.homeScore() &&
        actualGame.awayScore() == expectedGame.awayScore(),
      "Team names and scores should be equal");
  }
}
