package com.sportradar.scoreboard;

public class ScoreboardAssembler {

  public static Game givenGame(String home, String away, int homeScore, int awayScore) {
    return new Game(home, away).updateScore(homeScore, awayScore);
  }

}
