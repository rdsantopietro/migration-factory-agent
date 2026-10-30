package com.mfa.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RepositoryInventoryTest {

  @Test
  void acceptsValidInventory() {
    final RepositoryInventory inventory = new RepositoryInventory("Maven", "25", "Spring Boot");
    assertEquals("Maven", inventory.buildTool());
    assertEquals("25", inventory.javaVersion());
    assertEquals("Spring Boot", inventory.framework());
  }

  @Test
  void rejectsBlankBuildTool() {
    assertThrows(
        IllegalArgumentException.class, () -> new RepositoryInventory(" ", "25", "Spring Boot"));
  }

  @Test
  void rejectsBlankJavaVersion() {
    assertThrows(
        IllegalArgumentException.class, () -> new RepositoryInventory("Maven", "", "Spring Boot"));
  }
}
