package com.mfa.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mfa.application.AssessmentEngine;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

class MfaCommandTest {

  @Test
  void helpDisplaysAnalyzeCommand() {
    final StringWriter output = new StringWriter();
    final CommandLine commandLine = createCommandLine(output, new StringWriter());

    final int exitCode = commandLine.execute("--help");

    assertEquals(0, exitCode);
    assertTrue(output.toString().contains("analyze"));
  }

  @Test
  void noArgumentsPrintsUsage() {
    final StringWriter output = new StringWriter();
    final CommandLine commandLine = createCommandLine(output, new StringWriter());

    final int exitCode = commandLine.execute();

    assertEquals(0, exitCode);
    assertTrue(output.toString().contains("Usage:"));
    assertTrue(output.toString().contains("mfa"));
  }

  @Test
  void unknownCommandReturnsUsageError() {
    final StringWriter error = new StringWriter();
    final CommandLine commandLine = createCommandLine(new StringWriter(), error);

    final int exitCode = commandLine.execute("unknown");

    assertEquals(2, exitCode);
    assertFalse(error.toString().isBlank());
  }

  private static CommandLine createCommandLine(
      final StringWriter output, final StringWriter error) {
    return MfaCommand.createCommandLine(
        new AssessmentEngine(), new PrintWriter(output, true), new PrintWriter(error, true));
  }
}
