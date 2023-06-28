package com.example.logger.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.example.logger.enums.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AbstractLoggerTest {

  @Spy
  AbstractLogger logger = new NoopLogger(Level.NONE);

  @AfterEach
  void teardown() {
    logger.setLevel(Level.NONE);
  }

  @Test
  void shouldLogWhenLevelIsEqual() {
    logger.setLevel(Level.INFO);
    logger.info("Test");

    verify(logger).log("[INFO] Test");
  }

  @Test
  void shouldLogWhenLevelAbove() {
    logger.setLevel(Level.WARNING);
    logger.error("Test");

    verify(logger).log("[ERROR] Test");
  }

  @Test
  void shouldNotLogWhenLevelIsBelow() {
    logger.setLevel(Level.WARNING);
    logger.debug("Test");
    verify(logger, never()).log(any());
  }

  @Test
  void shouldNotLogAnyLevelWhenLevelIsNone() {
    logger.setLevel(Level.NONE);
    logger.debug("Test");
    logger.info("Test");
    logger.warning("Test");
    logger.error("Test");
    verify(logger, never()).log(any());
  }

}
