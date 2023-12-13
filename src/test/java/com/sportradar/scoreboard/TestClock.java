package com.sportradar.scoreboard;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicLong;

public class TestClock extends Clock {
  private AtomicLong time = new AtomicLong(0);

  @Override
  public ZoneId getZone() {
    return null;
  }

  @Override
  public Clock withZone(ZoneId zone) {
    return null;
  }

  @Override
  public Instant instant() {
    return Instant.ofEpochMilli(time.getAndIncrement());
  }
}
