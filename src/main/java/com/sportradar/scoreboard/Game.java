package com.sportradar.scoreboard;

public record Game(
  String homeTeam,
  String awayTeam,
  int homeScore,
  int awayScore,
  long startTime) {

  public Game(String homeTeam, String awayTeam) {
    this(homeTeam, awayTeam, 0, 0, System.currentTimeMillis());
  }

  public Game updateScore(int updatedHomeScore, int updatedAwayScore) {
    return new Game(homeTeam, awayTeam, updatedHomeScore, updatedAwayScore, startTime);
  }

  public String getKey() {
    return homeTeam + "-" + awayTeam;
  }
}
