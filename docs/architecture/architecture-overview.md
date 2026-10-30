# Architecture Overview

## Purpose

Migration Factory Agent is an application modernization platform designed to transform software migrations into a repeatable, governed, and traceable engineering process.

The platform assesses applications, selects supported modernization targets, plans migrations, executes validated migration knowledge, performs verification, and generates auditable evidence of every decision and transformation.

The MVP focuses on Java modernization and operates against local source code repositories.

---

# Architectural Principles

The platform is designed around the following principles:

- Knowledge-driven modernization
- Deterministic execution first
- Validation-driven workflows
- Human governance
- Incremental migrations
- Complete traceability
- Reusable migration knowledge
- Supported migration paths only

The platform prioritizes repeatability and predictability over autonomous code generation.

---

# High-Level Architecture

```text
Repository
    ↓
Assessment
    ↓
Baseline Validation
    ↓
Target Selection
    ↓
Compatibility Validation
    ↓
Migration Planning
    ↓
Recipe Resolution
    ↓
Recipe Execution
    ↓
Validation
    ↓
Knowledge Acquisition
    ↓
Governance Review
    ↓
Migration Report
```

---

# Major Components

## Assessment Engine

The Assessment Engine is responsible for analyzing repositories and establishing the migration baseline.

### Responsibilities

- Repository inspection
- Module discovery
- Technology detection
- Version detection
- Dependency inventory
- Build system detection
- Test asset discovery
- Coverage discovery
- Readiness assessment

### Outputs

- Baseline
- Technology Inventory
- Assessment Report
- Repository Metadata

The Assessment Engine never modifies source code.

---

## Baseline Validation Engine

The Baseline Validation Engine determines whether a repository can safely enter the modernization process.

### Validation Activities

- Build validation
- Compilation validation
- Test execution
- Coverage assessment

Validation establishes confidence in the current behavior of the application before any migration occurs.

If baseline validation fails, modernization cannot continue.

---

## Target Selection Engine

The Target Selection Engine determines the desired modernization destination.

Examples:

```text
Java 8 → Java 17
Java 17 → Java 21
Spring Boot 2.5 → Spring Boot 3.2
```

Target selection is governed by:

- Compatibility Matrix
- Supported Migration Paths
- Organizational Policies
- User Configuration

---

## Compatibility Engine

The Compatibility Engine verifies whether a migration path is supported.

Examples:

```text
Java 8 → Java 11     ✅
Java 11 → Java 17   ✅
Java 17 → Java 21   ✅

Java 8 → Java 25    ❌
```

Only supported migration paths may be planned and executed.

Unsupported paths terminate execution.

---

## Migration Planning Engine

The Planning Engine generates a modernization strategy using:

- Current application state
- Selected target state
- Compatibility rules
- Migration Knowledge Catalog

### Outputs

- Migration units
- Execution order
- Validation checkpoints
- Approval checkpoints
- Success criteria

Large migrations are decomposed into smaller migration units.

---

## Migration Knowledge Catalog

The Migration Knowledge Catalog is the central repository of modernization knowledge.

### Knowledge Sources

- OpenRewrite recipes
- Internal recipes
- Approved remediation patterns

The catalog is continuously expanded through the Knowledge Acquisition process.

Successful remediations created during migrations may become approved recipes after validation and review.

---

## Knowledge Acquisition Engine

The Knowledge Acquisition Engine is responsible for expanding migration knowledge over time.

When an existing recipe cannot resolve a scenario, engineers may create new remediations using OpenRewrite.

### Workflow

```text
Unsupported Scenario
        ↓
Manual Analysis
        ↓
OpenRewrite Remediation
        ↓
Validation
        ↓
Candidate Recipe
        ↓
Review
        ↓
Approval
        ↓
Migration Knowledge Catalog
```

### Responsibilities

- Detect unsupported scenarios
- Capture successful remediation patterns
- Generate candidate recipes
- Submit recipes for review
- Promote approved recipes into the catalog

### Example

```text
Company Library v1
        ↓
No Available Recipe
        ↓
Engineer Creates OpenRewrite Recipe
        ↓
Validation Success
        ↓
Recipe Approval
        ↓
Knowledge Catalog
```

Future migrations can reuse the recipe automatically.

---

## Recipe Resolution Engine

The Recipe Resolution Engine selects the appropriate migration knowledge for a migration unit.

### Responsibilities

- Recipe discovery
- Recipe matching
- Dependency resolution
- Execution ordering

Only approved recipes may be selected.

---

## Recipe Execution Engine

The Recipe Execution Engine performs deterministic transformations.

### Supported Activities

- Dependency upgrades
- Framework upgrades
- Source code transformations
- Build configuration updates
- Runtime configuration modernization

The preferred execution mechanism is OpenRewrite.

Only approved recipes may be executed automatically.

---

## Validation Engine

The Validation Engine verifies migration results.

### Validation Activities

- Build execution
- Compilation verification
- Test execution
- Coverage validation
- Compatibility verification

No migration is considered successful without validation evidence.

---

## Governance Engine

The Governance Engine controls workflow progression.

### Automatic Continuation

Allowed when:

- Build succeeds
- Tests pass
- Coverage meets threshold

### Human Approval Required

Required when:

- Coverage unavailable
- Coverage below threshold
- Reduced validation confidence

### Mandatory Stop Conditions

- Build failure
- Test failure
- Compatibility violation
- Unsupported migration path

Human approval cannot convert an unsupported migration into a supported migration.

---

## Traceability Engine

The Traceability Engine records auditable evidence across the modernization lifecycle.

### Evidence Collected

- Assessment results
- Baseline
- Migration plans
- Selected targets
- Applied recipes
- Validation results
- Approval decisions
- Migration reports

Every migration action must be reproducible.

---

## Reporting Engine

Generates final migration reports.

### Outputs

- Modernization summary
- Technology upgrades
- Applied recipes
- Validation evidence
- Approval history
- Migration metrics

Reports provide a complete audit trail.

---

# Multi-Module Architecture

Repositories may contain multiple modules.

```text
Repository
│
├── Module A
├── Module B
└── Module C
```

Each module is treated as an independent migration unit.

Validation occurs at:

1. Module level
2. Repository level

Repository success requires both levels to pass.

---

# AI Integration Model

Artificial Intelligence is not the primary modernization mechanism.

Migration relies on:

1. OpenRewrite recipes
2. Internal recipes
3. Approved remediation patterns

AI is used only when existing migration knowledge cannot resolve a scenario.

Examples:

- Unsupported code patterns
- Complex migrations
- Candidate recipe generation

AI may assist in generating candidate OpenRewrite recipes.

Generated recipes remain candidate knowledge until reviewed and approved.

AI cannot bypass governance policies, validation requirements, or compatibility rules.

---

# End-to-End Workflow

```text
Repository
    ↓
Assessment
    ↓
Baseline Validation
    ↓
Target Selection
    ↓
Compatibility Validation
    ↓
Migration Planning
    ↓
Recipe Resolution
    ↓
Recipe Execution
    ↓
Validation
    ↓
Knowledge Acquisition
    ↓
Governance Review
    ↓
Migration Report
```

---

# MVP Scope

Supported technologies:

- Java
- Spring Framework
- Spring Boot
- Maven
- Gradle

Execution occurs against local repositories.

---

# Future Roadmap Alignment

Future releases may incorporate:

- Internal recipe repository
- Recipe governance workflows
- AI-assisted remediation
- GitHub integration
- GitLab integration
- Portfolio modernization
- Additional ecosystems

---

# Architecture Constraints

The platform must never:

- Execute unsupported migration paths
- Skip validation gates
- Bypass governance controls
- Treat AI-generated content as approved knowledge
- Produce untraceable modifications

The platform must always:

- Prefer approved migration knowledge
- Generate auditable evidence
- Enforce validation checkpoints
- Preserve traceability
- Modernize incrementally
- Convert validated remediation patterns into reusable migration recipes