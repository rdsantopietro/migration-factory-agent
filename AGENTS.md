# Migration Factory Agent - Agent Instructions

## Purpose

Migration Factory Agent is a deterministic, governed, and traceable application modernization platform.

Primary principles:

- Deterministic execution first
- Validation-driven modernization
- Human governance
- Knowledge-driven modernization
- Incremental migrations
- Complete traceability
- Knowledge enrichment

AI is NOT the primary modernization mechanism. AI is only used when reusable migration knowledge cannot resolve a migration scenario.

## Technology Stack

- Java 25
- Spring Boot 4.x
- Spring Framework 7.x
- Maven (through the committed Maven Wrapper)
- Picocli
- Jackson
- Lombok (`@RequiredArgsConstructor`, `@Slf4j`)
- SLF4J
- JUnit 5
- JaCoCo
- Spotless
- Checkstyle
- OpenRewrite (planned for migration execution)

## Architecture Rules

Follow Clean Architecture.

Package structure:

```text
com.mfa
├── cli
├── application
├── domain
├── infrastructure
└── shared
```

## Coding Rules

- Prefer Java Records where appropriate.
- Use Lombok `@RequiredArgsConstructor` for constructor injection when a record is not appropriate.
- Use Lombok `@Slf4j` (SLF4J) for logging.
- Constructor injection only.
- Avoid field injection.
- Do not use Lombok for anything other than `@RequiredArgsConstructor` and `@Slf4j`.
- Avoid static utility classes when a service is more appropriate.
- Keep the domain model immutable.
- Add unit tests for all business logic.

## Important Constraints

- Never introduce REST APIs.
- Never introduce databases.
- Never introduce messaging systems.
- Never introduce Spring MVC.
- Never introduce Spring Data.
- This application is a CLI application.
- Do not introduce Python, Typer, Pydantic, or Pytest; the project is Java-only.

## Assessment Engine Design

```text
CLI
 ↓
AssessmentEngine
 ↓
Analyzers
 ↓
RepositoryInventory
```

Commands must not directly invoke multiple analyzers.

Always use the AssessmentEngine.

## CLI Design

- The root command is `mfa`.
- Subcommands delegate to application services and must not contain analysis logic.
- Exit codes are `0` for success, `1` for execution or validation errors, and `2` for invalid command-line usage.
- `mfa analyze <repository>` validates the repository path and delegates to `AssessmentEngine`.

## Build Validation

Before completing a task:

```bash
JAVA_HOME=/path/to/jdk-25+ ./mvnw clean verify
```

must complete successfully.

Fix compilation errors before considering the task complete.

The project requires JDK 25 or newer. Use the committed Maven Wrapper (`mvnw` or `mvnw.cmd`); a local Maven installation is not required.

## Java Coding Standards

### Records

Prefer compact single-line records when they contain only a small number of fields.

Preferred:

```java
public record RepositoryInventory(String buildTool, String javaVersion, String framework) {}
```

Use multiline records only when readability clearly improves due to the number of fields.

Example:

```java
public record RepositoryAssessment(
    String repositoryName,
    BuildTool buildTool,
    String javaVersion,
    String springBootVersion,
    int moduleCount,
    int dependencyCount,
    AssessmentStatus status) {}
```

### Formatting

- Prefer concise and readable code.
- Do not add unnecessary blank lines between fields, methods, or annotations.
- Avoid excessive vertical spacing.
- Keep simple constructors, records, and method signatures on a single line.
- Use multiline formatting only when line length or readability requires it.
- Spotless runs `google-java-format`, which enforces a 100-column limit. Keep any statement that fits in 100 columns on a single line; the formatter splits longer lines automatically, so never wrap manually.
- The Checkstyle 120-column limit is only an upper bound, not a target for manual line breaks.

Preferred:

```java
private final AssessmentEngine assessmentEngine;
```

```java
public class AssessmentEngine {
  public void assess(Path repository) {
    // ...
  }
}
```

Avoid unnecessary wrapping:

```java
private final AssessmentEngine
    assessmentEngine;
```

```java
public class AssessmentEngine {

  public void assess(
      Path repository) {

  }

}
```

### Logging

Use SLF4J through Lombok's `@Slf4j`. Never use `System.out` or `System.err` for diagnostics.

```java
@Slf4j
@RequiredArgsConstructor
public class AnalyzeCommand {

  private final AssessmentEngine assessmentEngine;

  public void analyze(Path repository) {
    log.info("Analyzing repository {}", repository.toAbsolutePath());
    this.assessmentEngine.assess(repository);
  }
}
```

- Use parameterized messages (`log.info("Analyzing {}", path)`) instead of string concatenation.
- Use `INFO` for relevant business events, `DEBUG` for diagnostic detail, and `ERROR` only for failures.
- Keep user-facing CLI output on the command writers; use the logger for operational traceability.

### Constructor Injection

When a class is not a record, use `@RequiredArgsConstructor` instead of writing the constructor manually.

Preferred:

```java
@RequiredArgsConstructor
public class AnalyzeCommand {

  private final AssessmentEngine assessmentEngine;
  private final PrintWriter outputWriter;
}
```

Avoid:

```java
public class AnalyzeCommand {

  private final AssessmentEngine assessmentEngine;
  private final PrintWriter outputWriter;

  public AnalyzeCommand(AssessmentEngine assessmentEngine, PrintWriter outputWriter) {
    this.assessmentEngine = assessmentEngine;
    this.outputWriter = outputWriter;
  }
}
```

### Lombok

- Lombok is allowed only for `@Slf4j` and `@RequiredArgsConstructor`.
- The version is managed by the Spring Boot parent; do not pin it in `pom.xml`.
- Annotation processing is configured in `maven-compiler-plugin` through `<proc>full</proc>` plus `annotationProcessorPaths`, which is required on JDK 23 and newer.
- Lombok stays `optional` and is excluded from the Spring Boot jar.
- Tests may use plain constructors or inheritance; Lombok is not required there.

### General Style

- Prefer modern Java 25 style.
- Prefer records over DTO classes.
- Prefer immutable objects.
- Prefer explicit names over abbreviations.
- Minimize boilerplate.
- Optimize for readability rather than framework conventions.
