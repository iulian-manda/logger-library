package com.example.logger.impl;

import com.example.logger.Logger;
import com.example.logger.enums.Level;
import com.example.logger.enums.Target;
import com.example.logger.exceptions.TargetNotImplementedException;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerImpl implements Logger {

  private final ConcurrentHashMap<Target, AbstractLogger> targets = new ConcurrentHashMap<>();

  public LoggerImpl() {
    targets.put(Target.CONSOLE, ConsoleLogger.getInstance(Level.NONE));
    targets.put(Target.EMAIL, EmailLogger.getInstance(Level.NONE));
  }

  @Override
  public synchronized void setLevel(Target target, Level level) {
    AbstractLogger logger = targets.get(target);
    if (logger == null) {
      throw new TargetNotImplementedException(target);
    }
    logger.setLevel(level);
  }

  @Override
  public void debug(String msg) {
    targets.values().forEach((logger -> logger.debug(msg)));
  }

  @Override
  public void info(String msg) {
    targets.values().forEach((logger -> logger.info(msg)));
  }

  @Override
  public void warning(String msg) {
    targets.values().forEach((logger -> logger.warning(msg)));
  }

  @Override
  public void error(String msg) {
    targets.values().forEach((logger -> logger.error(msg)));
  }
}
