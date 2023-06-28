package com.example.logger.impl;

import com.example.logger.enums.Level;

public abstract class AbstractLogger {

  private Level level;

  public AbstractLogger(Level level) {
    this.level = level;
  }

  abstract void log(String msg);

  public void setLevel(Level level) {
    this.level = level;
  }

  public synchronized void debug(String msg) {
    logWithLevel(Level.DEBUG, msg);
  }

  public synchronized void info(String msg) {
    logWithLevel(Level.INFO, msg);
  }

  public synchronized void warning(String msg) {
    logWithLevel(Level.WARNING, msg);
  }

  public synchronized void error(String msg) {
    logWithLevel(Level.ERROR, msg);
  }

  private void logWithLevel(Level currentLevel, String msg) {
    if (level.isEnabled(currentLevel)) {
      String enhancedMessage = "[" + currentLevel + "] " + msg;
      log(enhancedMessage);
    }
  }
}
