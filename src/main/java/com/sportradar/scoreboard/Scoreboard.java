package com.sportradar.scoreboard;

import java.util.List;

public interface Scoreboard {

  /**
   * Starts a new game between two teams.
   * @param homeTeam
   * @param awayTeam
   */
  void startGame(String homeTeam, String awayTeam);

  /**
   * Updates the score of an existing game.
   * @param homeTeam
   * @param awayTeam
   * @param homeScore
   * @param awayScore
   * @throws IllegalArgumentException if the game does not exist.
   */
  void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);

  /**
   * Finishes an existing game.
   * @throws IllegalArgumentException if the game does not exist.
   * @param homeTeam
   * @param awayTeam
   */
  void finishGame(String homeTeam, String awayTeam);

  /**
   * Returns a list of all games.
   */
  List<Game> getSummary();
}
