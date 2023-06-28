package com.example.logger.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.logger.Logger;
import com.example.logger.LoggerFactory;
import com.example.logger.enums.Level;
import com.example.logger.enums.Target;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoggerIntegrationTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  void shouldCreateOneLogger() {
    Logger logger = LoggerFactory.getInstance();
    Logger secondLogger = LoggerFactory.getInstance();

    assertSame(logger, secondLogger);
  }

  @Test
  void shouldLogAllTargets() {
    Logger logger = LoggerFactory.getInstance();

    logger.setLevel(Target.CONSOLE, Level.DEBUG);
    logger.setLevel(Target.EMAIL, Level.ERROR);

    logger.debug("Test");
    logger.info("Test");
    logger.warning("Test");
    logger.error("Test");

    String logged = outContent.toString();
    assertTrue(logged.contains("[DEBUG] Test"));
    assertTrue(logged.contains("[INFO] Test"));
    assertTrue(logged.contains("[WARNING] Test"));
    assertTrue(logged.contains("[ERROR] Test"));
    assertTrue(logged.contains("Sending email with log: [ERROR] Test"));
  }

}
