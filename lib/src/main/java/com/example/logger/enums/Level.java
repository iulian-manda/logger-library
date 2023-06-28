package com.example.logger.enums;

public enum Level {

  ERROR(30, "ERROR"),
  WARNING(20, "WARNING"),
  INFO(10, "INFO"),
  DEBUG(0, "DEBUG"),
  NONE(Integer.MAX_VALUE, "NONE");

  private final int levelInt;
  private final String levelString;

  Level(int levelInt, String levelString) {
    this.levelInt = levelInt;
    this.levelString = levelString;
  }

  public boolean isEnabled(Level level) {
    return this.levelInt <= level.levelInt;
  }

  @Override
  public String toString() {
    return levelString;
  }
}
