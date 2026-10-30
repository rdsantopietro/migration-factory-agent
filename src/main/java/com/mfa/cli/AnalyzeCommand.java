package com.mfa.cli;

import com.mfa.application.AssessmentEngine;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

@Slf4j
@RequiredArgsConstructor
@Command(name = "analyze", description = "Analyze a repository for modernization readiness.")
public class AnalyzeCommand implements Callable<Integer> {

  private final AssessmentEngine assessmentEngine;

  @Spec private CommandSpec spec;

  @Parameters(paramLabel = "<repository>", description = "Path to the repository to analyze.")
  private Path repository;

  @Override
  public Integer call() {
    if (this.repository == null || !Files.isDirectory(this.repository)) {
      final PrintWriter errorWriter = this.spec.commandLine().getErr();
      errorWriter.printf("Repository directory not found: %s%n", this.repository);
      errorWriter.flush();
      return 1;
    }
    log.debug("Executing analyze command for {}", this.repository.toAbsolutePath());
    this.assessmentEngine.assess(this.repository);
    final PrintWriter outputWriter = this.spec.commandLine().getOut();
    outputWriter.printf("Assessment completed for %s%n", this.repository.toAbsolutePath());
    outputWriter.flush();
    return 0;
  }
}
