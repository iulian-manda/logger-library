package com.example.logger.impl;

import com.example.logger.enums.Level;

public class EmailLogger extends AbstractLogger {

  private static final Object lock = new Object();
  private static volatile EmailLogger instance;

  private EmailLogger(Level level) {
    super(level);
  }

  public static AbstractLogger getInstance(Level level) {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new EmailLogger(level);
        }
      }
    }
    return instance;
  }

  @Override
  void log(String msg) {
    System.out.println("Sending email with log: " + msg);
  }
}
