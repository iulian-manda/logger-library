package com.example.logger;

import com.example.logger.impl.LoggerImpl;

public class LoggerFactory {

  private static final Object lock = new Object();
  private static volatile Logger instance;

  public static Logger getInstance() {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new LoggerImpl();
        }
      }
    }
    return instance;
  }

}
