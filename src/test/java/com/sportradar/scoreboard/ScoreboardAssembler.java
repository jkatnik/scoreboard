package com.sportradar.scoreboard;

public class ScoreboardAssembler {
  private Scoreboard scoreboard;

  public ScoreboardAssembler(Scoreboard scoreboard) {
    this.scoreboard = scoreboard;
  }

  public static ScoreboardAssembler given(Scoreboard scoreboard) {
    return new ScoreboardAssembler(scoreboard);
  }

  public ScoreboardAssembler withGame(String home, String away, int homeScore, int awayScore) {
    scoreboard.startGame(home, away);
    scoreboard.updateScore(home, away, homeScore, awayScore);
    return this;
  }

  public ScoreboardAssembler startGame(String home, String away) {
    scoreboard.startGame(home, away);
    return this;
  }

  public static Game givenGame(String home, String away, int homeScore, int awayScore) {
    return new Game(home, away).updateScore(homeScore, awayScore);
  }

}
