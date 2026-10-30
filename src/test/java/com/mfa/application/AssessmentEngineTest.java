package com.mfa.application;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AssessmentEngineTest {

  @Test
  void rejectsNullRepository() {
    final AssessmentEngine assessmentEngine = new AssessmentEngine();

    assertThrows(NullPointerException.class, () -> assessmentEngine.assess(null));
  }
}
