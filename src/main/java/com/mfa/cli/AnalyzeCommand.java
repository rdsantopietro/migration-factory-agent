package com.mfa.cli;

import com.mfa.application.AssessmentEngine;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Slf4j
@RequiredArgsConstructor
@Command(name = "analyze", description = "Analyze a repository for modernization readiness.")
public class AnalyzeCommand implements Callable<Integer> {

  private final AssessmentEngine assessmentEngine;
  private final PrintWriter outputWriter;
  private final PrintWriter errorWriter;

  @Parameters(
      index = "0",
      paramLabel = "<repository>",
      description = "Path to the repository to analyze.")
  private Path repository;

  @Override
  public Integer call() {
    if (this.repository == null || !Files.isDirectory(this.repository)) {
      this.errorWriter.printf("Repository directory not found: %s%n", this.repository);
      this.errorWriter.flush();
      return 1;
    }

    log.info("Analyzing repository {}", this.repository.toAbsolutePath());
    this.assessmentEngine.assess(this.repository);
    this.outputWriter.printf("Assessment completed for %s%n", this.repository.toAbsolutePath());
    this.outputWriter.flush();
    return 0;
  }
}
