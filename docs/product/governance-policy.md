# Governance Policy

## Purpose

This document defines the decision rules governing migration execution.

The policy determines when migrations may continue automatically, when they require human approval and when they must stop.

---

# Decision Categories

Migration decisions fall into three categories:

- Automatic Continuation
- Human Approval Required
- Mandatory Stop

---

# Automatic Continuation

Migration execution may continue automatically when all configured governance conditions are satisfied.

Examples may include:

- Build succeeds.
- All executed tests pass.
- Coverage information is available.
- Coverage satisfies the configured threshold.

The exact governance thresholds are configuration-driven and may vary between organizations, repositories or migration programs.

---

# Human Approval Required

Migration execution requires explicit approval when confidence is reduced but migration remains technically viable.

Examples include:

- Coverage below the configured threshold.
- Coverage information unavailable.
- Coverage tooling unavailable.
- Elevated migration complexity.
- Reduced validation confidence.
- Missing non-blocking migration evidence.

Approval authorizes continuation under the organization's governance policies.

---

# Mandatory Stop Conditions

Migration execution must stop immediately when:

- Build fails.
- Compilation fails.
- A required validation fails.
- Any executed test fails.
- The migration path is unsupported.
- Compatibility rules are violated.

Human approval cannot convert an unsupported migration into a supported migration.

---

# Coverage Governance

Coverage contributes to migration confidence.

Coverage does not determine functional correctness.

---

## Coverage Available

Coverage should be measured whenever technically possible.

Coverage results should be evaluated against the configured governance threshold.

---

## Coverage Below Threshold

Coverage below the configured threshold requires human approval before migration execution may continue.

---

## Coverage Unavailable

When tests exist but coverage measurement is unavailable, the platform should recommend adoption of a supported coverage tool.

Examples include:

- JaCoCo

The recommendation does not automatically modify the application unless explicitly authorized by the user.

---

## No Automated Tests Available

When automated tests are unavailable, the platform must indicate reduced validation confidence.

Migration continuation requires human review according to the organization's governance policies.

---

# Approval Records

All approvals must be traceable.

Approval records should include:

- Decision
- Rationale
- Reviewer
- Timestamp
- Associated migration context

---

# Policy Configuration

Governance policies may define configurable parameters, including:

- Coverage thresholds
- Approval requirements
- Validation requirements
- Risk tolerance levels
- Escalation rules

Migration Factory Agent must evaluate governance decisions using the active policy configuration rather than hardcoded values.