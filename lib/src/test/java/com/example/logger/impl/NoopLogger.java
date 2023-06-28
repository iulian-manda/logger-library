package com.example.logger.impl;

import com.example.logger.enums.Level;

public class NoopLogger extends AbstractLogger {

  public NoopLogger(Level level) {
    super(level);
  }

  @Override
  void log(String msg) {
    // noop
  }
}
