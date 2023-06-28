package com.example.logger.exceptions;

import com.example.logger.enums.Target;

public class TargetNotImplementedException extends RuntimeException {

  public TargetNotImplementedException(Target target) {
    super("Current target [" + target + "] is not implemented");
  }
}
