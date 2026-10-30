package com.mfa.domain;

public record RepositoryInventory(String buildTool, String javaVersion, String framework) {

  public RepositoryInventory {
    if (isBlank(buildTool)) {
      throw new IllegalArgumentException("buildTool must not be blank");
    }
    if (isBlank(javaVersion)) {
      throw new IllegalArgumentException("javaVersion must not be blank");
    }
  }

  private static boolean isBlank(final String value) {
    return value == null || value.isBlank();
  }
}
