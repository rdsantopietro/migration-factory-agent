package com.mfa.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mfa.application.AssessmentEngine;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import picocli.CommandLine;

class AnalyzeCommandTest {

  @TempDir Path repository;

  @Test
  void delegatesRepositoryToAssessmentEngine() {
    final RecordingAssessmentEngine assessmentEngine = new RecordingAssessmentEngine();
    final StringWriter output = new StringWriter();
    final CommandLine commandLine = createCommandLine(assessmentEngine, output, new StringWriter());

    final int exitCode = commandLine.execute("analyze", this.repository.toString());

    assertEquals(0, exitCode);
    assertEquals(this.repository, assessmentEngine.lastRepository);
    assertTrue(output.toString().contains("Assessment completed"));
  }

  @Test
  void missingRepositoryArgumentReturnsUsageError() {
    final StringWriter error = new StringWriter();
    final CommandLine commandLine =
        createCommandLine(new AssessmentEngine(), new StringWriter(), error);

    final int exitCode = commandLine.execute("analyze");

    assertEquals(2, exitCode);
    assertTrue(error.toString().contains("Missing required parameter"));
  }

  @Test
  void nonExistentRepositoryReturnsError() {
    final StringWriter error = new StringWriter();
    final CommandLine commandLine =
        createCommandLine(new AssessmentEngine(), new StringWriter(), error);
    final Path missingRepository = this.repository.resolve("missing");

    final int exitCode = commandLine.execute("analyze", missingRepository.toString());

    assertEquals(1, exitCode);
    assertTrue(error.toString().contains("Repository directory not found"));
  }

  private static CommandLine createCommandLine(
      final AssessmentEngine assessmentEngine,
      final StringWriter output,
      final StringWriter error) {
    return MfaCommand.createCommandLine(
        assessmentEngine, new PrintWriter(output, true), new PrintWriter(error, true));
  }

  private static final class RecordingAssessmentEngine extends AssessmentEngine {

    private Path lastRepository;

    @Override
    public void assess(final Path repository) {
      this.lastRepository = repository;
    }
  }
}
