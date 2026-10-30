# Modernization Assessment

## Purpose

This document defines how Migration Factory Agent evaluates an application before migration planning begins.

The assessment process establishes the current state of an application, identifies modernization opportunities, detects constraints and determines whether sufficient information exists to proceed with migration planning.

The assessment informs planning decisions but does not perform migrations.

---

# Objectives

The modernization assessment exists to:

- Understand the current application state.
- Identify modernization opportunities.
- Detect migration constraints.
- Determine migration readiness.
- Support target selection.
- Support migration planning.
- Establish a migration baseline.

---

# Assessment Principles

## Evidence-Based Assessment

Assessment results must be based on observable application characteristics.

Assumptions should be avoided whenever possible.

---

## Technology-Aware Evaluation

Assessment activities must consider the technologies detected within the application.

---

## Reproducibility

Equivalent repositories should produce equivalent assessment results.

---

## Traceability

Assessment findings must be traceable to discovered application evidence.

---

# Assessment Areas

## Repository Assessment

The platform evaluates the repository structure.

Assessment includes:

- Repository layout
- Project structure
- Module structure
- Build assets
- Configuration assets

---

## Technology Assessment

The platform identifies the technologies present in the application.

Assessment includes:

- Programming languages
- Frameworks
- Build systems
- Runtime technologies
- Libraries and dependencies

---

## Version Assessment

The platform identifies relevant technology versions.

Assessment includes:

- Runtime versions
- Framework versions
- Build tool versions
- Dependency versions

---

## Module Assessment

The platform evaluates individual modules.

Assessment includes:

- Module discovery
- Module relationships
- Dependency relationships
- Module-specific technologies

---

## Build Assessment

The platform evaluates the build state of the application.

Assessment includes:

- Build configuration
- Build consistency
- Build execution status
- Build tooling availability

---

## Test Assessment

The platform evaluates available automated tests.

Assessment includes:

- Test discovery
- Test types
- Test execution status
- Test organization

---

## Coverage Assessment

When possible, the platform evaluates available coverage information.

Assessment includes:

- Coverage availability
- Coverage measurement support
- Coverage reporting availability

Coverage metrics contribute to migration confidence but do not determine application correctness.

---

## Dependency Assessment

The platform evaluates dependency characteristics.

Assessment includes:

- Dependency inventory
- Dependency age
- Dependency compatibility
- Dependency constraints

---

## Compatibility Assessment

The platform evaluates compatibility with supported modernization paths.

Assessment includes:

- Supported source states
- Reachable target states
- Intermediate upgrade requirements
- Known compatibility constraints

---

# Migration Readiness Assessment

The platform evaluates whether migration planning can proceed.

Readiness assessment considers:

- Build status
- Test availability
- Coverage availability
- Technology support status
- Compatibility constraints
- Migration prerequisites

Readiness does not guarantee migration success.

Readiness indicates whether planning activities can proceed with acceptable confidence.

---

# Assessment Outcomes

Assessment produces:

## Baseline

A documented representation of the current application state.

---

## Technology Inventory

A catalog of detected technologies and versions.

---

## Compatibility Findings

Identified compatibility opportunities and constraints.

---

## Migration Opportunities

Supported modernization paths available to the application.

---

## Migration Constraints

Conditions that may restrict modernization activities.

---

## Readiness Findings

The platform's assessment of migration readiness.

---

# Assessment Limitations

Assessment findings are limited by:

- Available repository contents
- Available build information
- Available test assets
- Available coverage information
- Supported technology recognition

The assessment cannot guarantee functional correctness of the application.

---

# Assessment Success Criteria

An assessment is considered successful when it can:

- Identify the application structure.
- Identify supported technologies.
- Determine relevant versions.
- Establish a baseline.
- Identify supported modernization opportunities.
- Detect significant migration constraints.
- Produce traceable assessment evidence.

---

# Related Documents

- vision.md
- product-scope.md
- migration-knowledge-catalog.md
- migration-strategy.md
- migration-capabilities.md