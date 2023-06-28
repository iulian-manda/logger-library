package com.example.logger.impl;

import com.example.logger.enums.Level;

public class ConsoleLogger extends AbstractLogger {

  private static final Object lock = new Object();
  private static volatile ConsoleLogger instance;

  private ConsoleLogger(Level level) {
    super(level);
  }

  public static AbstractLogger getInstance(Level level) {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new ConsoleLogger(level);
        }
      }
    }
    return instance;
  }

  @Override
  void log(String msg) {
    System.out.println(msg);
  }
}
