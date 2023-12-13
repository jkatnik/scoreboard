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
    return Game.getKey(homeTeam, awayTeam);
  }

  public static String getKey(String homeTeam, String awayTeam) {
    return homeTeam + "-" + awayTeam;
  }
}
