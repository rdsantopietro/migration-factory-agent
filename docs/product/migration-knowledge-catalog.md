# Migration Knowledge Catalog

## Purpose

This document defines the authoritative migration knowledge used by Migration Factory Agent to evaluate, plan and execute modernization activities.

The Migration Knowledge Catalog establishes which modernization capabilities are supported by the platform, the compatibility rules that govern them, the migration paths that can be executed and the transformation knowledge available to perform them.

This catalog acts as the source of truth for migration planning and execution.

---

# Objectives

The Migration Knowledge Catalog exists to:

- Define supported modernization capabilities.
- Define supported migration paths.
- Define compatibility constraints.
- Define migration prerequisites.
- Define reusable migration knowledge.
- Enable deterministic migration planning.
- Ensure migration consistency across repositories.
- Prevent unsupported modernization activities.

---

# Core Principles

## Knowledge-Driven Modernization

Migration decisions must be based on documented and supported migration knowledge.

No migration should rely exclusively on ad-hoc transformations.

---

## Explicit Compatibility

All supported migration paths must be explicitly defined.

Unsupported paths are considered invalid by default.

---

## Reusable Knowledge

Migration knowledge should be reusable across repositories and modernization initiatives.

Knowledge discovered during migrations should be incorporated into the catalog when validated and approved.

---

## Controlled Evolution

The catalog must evolve through governed updates.

New migration knowledge does not become supported automatically.

---

# Catalog Structure

The catalog is composed of several knowledge domains.

## Migration Capabilities

Migration capabilities define what types of modernization activities the platform can perform.

Examples include:

- Java runtime upgrades
- Spring Framework upgrades
- Spring Boot upgrades
- Dependency modernization
- Build system modernization
- Configuration modernization

A migration capability defines a supported modernization objective.

---

## Compatibility Rules

Compatibility rules define which source and target states are considered valid.

Compatibility rules may define:

- Supported source versions
- Supported target versions
- Required intermediate versions
- Framework constraints
- Dependency constraints
- Build system constraints

Compatibility rules determine whether a migration path can be planned.

---

## Migration Matrix

The Migration Matrix represents the set of supported migration paths derived from the compatibility rules.

Each entry defines:

- Source state
- Target state
- Support status
- Required prerequisites
- Required intermediate steps

Example:

| Source | Target | Supported |
|----------|----------|----------|
| Java 8 | Java 11 | Yes |
| Java 11 | Java 17 | Yes |
| Spring Boot 2.7 | Spring Boot 3.x | Yes |

The Migration Matrix determines which modernization targets are reachable from a given application state.

---

## Migration Recipes

Migration recipes define reusable transformation knowledge.

Recipes describe how a supported migration capability is implemented.

Examples include:

- Source-code transformations
- Dependency updates
- Build configuration updates
- Framework configuration changes
- Runtime configuration changes

Recipes should be deterministic, repeatable and independently testable.

---

## Validation Requirements

Validation requirements define the evidence required to verify a migration outcome.

Requirements may include:

- Build validation
- Compilation validation
- Test execution
- Coverage assessment
- Compatibility verification

Validation requirements are associated with migration capabilities and migration paths.

---

## Approved Remediation Patterns

Approved remediation patterns capture migration knowledge discovered after resolving previously unsupported or partially supported scenarios.

These patterns may originate from:

- Engineering reviews
- Migration projects
- Manual remediations
- Expert recommendations

Approved remediation patterns become reusable migration knowledge once reviewed and accepted.

---

# Knowledge Sources

Migration knowledge may originate from:

- Vendor migration guides
- Framework migration guides
- Platform engineering standards
- Supported migration recipes
- Approved remediation patterns
- Internal modernization standards

All knowledge sources must be traceable.

---

# Governance

## Supported Knowledge

Only approved migration knowledge may be used to define supported migration capabilities.

---

## Knowledge Review

New migration knowledge must be reviewed before becoming part of the catalog.

Review should verify:

- Technical correctness
- Repeatability
- Compatibility impact
- Validation requirements

---

## Knowledge Versioning

Changes to migration knowledge must be versioned and traceable.

The platform must be able to identify which version of the catalog was used to generate a migration plan.

---

# Catalog Usage

The Migration Knowledge Catalog is used during:

1. Repository assessment.
2. Modernization readiness evaluation.
3. Target selection.
4. Migration planning.
5. Migration execution.
6. Migration validation.
7. Migration reporting.

All migration decisions should be traceable to information contained within the catalog.

---

# Out of Scope

This document does not define:

- Product architecture
- Internal execution engines
- Repository storage mechanisms
- Workflow orchestration
- User interface behavior

These concerns are documented separately.