# Migration Capabilities

## Purpose

This document defines the modernization capabilities supported by Migration Factory Agent.

A migration capability represents a supported modernization outcome that can be planned, executed and validated by the platform using approved migration knowledge.

This document establishes what the platform can modernize, the scope of each capability and the expected outcomes.

Implementation details, execution mechanisms and architecture decisions are defined separately.

---

# Capability Model

A migration capability defines:

- A modernization objective
- Supported source states
- Supported target states
- Applicable compatibility rules
- Required migration knowledge
- Validation requirements
- Expected outcomes

A capability is considered supported only when sufficient migration knowledge exists to execute and validate it consistently.

---

# Core Principles

## Explicit Support

Only documented capabilities are considered supported.

Capabilities cannot be inferred from available tools or technologies.

---

## Knowledge-Based Execution

Capabilities must be backed by approved migration knowledge.

All transformations must be traceable to documented modernization knowledge.

---

## Validation Required

A capability is only considered successful when the resulting application state satisfies its validation requirements.

---

## Repeatability

Supported capabilities should produce consistent outcomes when executed against equivalent application states.

---

# Capability Categories

## Runtime Modernization

Runtime modernization capabilities upgrade the runtime environment required by an application.

Examples include:

- Java runtime upgrades
- Java compiler upgrades
- Runtime configuration modernization

Expected outcomes include:

- Supported runtime versions
- Updated compiler configuration
- Compatibility with target runtime requirements

---

## Framework Modernization

Framework modernization capabilities upgrade application frameworks to supported target versions.

Examples include:

- Spring Framework upgrades
- Spring Boot upgrades

Expected outcomes include:

- Supported framework versions
- Updated framework configuration
- Compatibility with framework requirements

---

## Dependency Modernization

Dependency modernization capabilities update application dependencies.

Examples include:

- Dependency version alignment
- Dependency replacement
- Dependency compatibility remediation

Expected outcomes include:

- Supported dependency versions
- Reduced compatibility issues
- Improved maintainability

---

## Build Modernization

Build modernization capabilities update the build ecosystem used by an application.

Examples include:

- Maven modernization
- Gradle modernization
- Build plugin modernization

Expected outcomes include:

- Updated build configuration
- Supported build tooling
- Improved compatibility with target technologies

---

## Configuration Modernization

Configuration modernization capabilities update application configuration required by supported migration paths.

Examples include:

- Framework configuration updates
- Runtime configuration updates
- Build configuration updates

Expected outcomes include:

- Compatible configuration state
- Alignment with target technology requirements

---

## Source Code Modernization

Source code modernization capabilities perform code transformations required by supported modernization paths.

Examples include:

- API replacements
- Package migrations
- Configuration API updates
- Framework migration adaptations

Expected outcomes include:

- Source code compatibility
- Compilation compatibility
- Framework compatibility

---

# MVP Capabilities

The MVP supports modernization activities within the Java ecosystem.

## Supported Languages

- Java

---

## Supported Frameworks

- Spring Framework
- Spring Boot

---

## Supported Build Systems

- Maven
- Gradle

---

## Supported Capability Areas

### Java Modernization

The platform supports Java modernization paths defined in the Migration Knowledge Catalog.

---

### Spring Framework Modernization

The platform supports Spring Framework modernization paths defined in the Migration Knowledge Catalog.

---

### Spring Boot Modernization

The platform supports Spring Boot modernization paths defined in the Migration Knowledge Catalog.

---

### Dependency Modernization

The platform supports dependency updates associated with supported modernization paths.

---

### Build Modernization

The platform supports build updates required by supported modernization paths.

---

# Capability Lifecycle

Every capability follows a lifecycle.

## Discovery

The platform identifies whether a capability is applicable to the application.

---

## Compatibility Evaluation

The platform determines whether the capability can be applied to the current application state.

---

## Planning

The capability is incorporated into a migration plan.

---

## Execution

Supported transformations are applied.

---

## Validation

The resulting application state is validated.

---

## Completion

The capability is considered complete when all validation requirements are satisfied.

---

# Capability Constraints

The following constraints apply to all capabilities.

- Capabilities must be supported by the Migration Knowledge Catalog.
- Capabilities must satisfy compatibility rules.
- Capabilities must produce traceable evidence.
- Capabilities must define validation requirements.
- Capabilities cannot bypass governance policies.
- Unsupported transformations are not considered supported capabilities.

---

# Capability Success Criteria

A capability is considered successful when:

- The intended modernization objective is achieved.
- Validation requirements pass successfully.
- Compatibility requirements are satisfied.
- Evidence is generated and preserved.
- Governance requirements are satisfied.

---

# Related Documents

- migration-knowledge-catalog.md
- migration-strategy.md
- modernization-assessment.md
- validation-policy.md
- governance-policy.md