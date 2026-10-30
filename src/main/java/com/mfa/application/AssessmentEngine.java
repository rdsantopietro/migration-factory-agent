package com.mfa.application;

import java.nio.file.Path;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssessmentEngine {

  public void assess(final Path repository) {
    Objects.requireNonNull(repository, "repository must not be null");
    log.info("Starting assessment for repository {}", repository.toAbsolutePath());
    // Analyzer orchestration will be wired in as the assessment workflow matures.
  }
}
