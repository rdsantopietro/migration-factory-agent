package com.mfa.cli;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mfa.application.AssessmentEngine;
import com.mfa.domain.RepositoryInventory;
import org.junit.jupiter.api.Test;

class MigrationFactoryAgentCliTest {

  @Test
  void runAssessesTheRepositoryInventory() {
    final RecordingAssessmentEngine assessmentEngine = new RecordingAssessmentEngine();
    final MigrationFactoryAgentCli cli = new MigrationFactoryAgentCli(assessmentEngine);

    assertDoesNotThrow(cli::run);

    assertEquals("Maven", assessmentEngine.lastInventory.buildTool());
  }

  private static final class RecordingAssessmentEngine extends AssessmentEngine {

    private RepositoryInventory lastInventory;

    @Override
    public void assess(final RepositoryInventory repositoryInventory) {
      this.lastInventory = repositoryInventory;
    }
  }
}
