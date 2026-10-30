package com.mfa.cli;

import com.mfa.application.AssessmentEngine;
import com.mfa.domain.RepositoryInventory;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "migration-factory-agent",
    version = {"0.0.1"},
    description = {"AI-powered application modernization platform."})
public class MigrationFactoryAgentCli implements Runnable {

  private final AssessmentEngine assessmentEngine;

  public MigrationFactoryAgentCli(final AssessmentEngine assessmentEngine) {
    this.assessmentEngine = assessmentEngine;
  }

  @Override
  public void run() {
    final RepositoryInventory inventory = new RepositoryInventory("Maven", "25", "Spring Boot");
    this.assessmentEngine.assess(inventory);
  }

  public static void main(final String[] args) {
    final int exitCode =
        new CommandLine(new MigrationFactoryAgentCli(new AssessmentEngine())).execute(args);
    if (exitCode != 0) {
      System.exit(exitCode);
    }
  }
}
