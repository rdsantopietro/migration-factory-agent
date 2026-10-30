Migration Factory Agent - Agent Instructions
Purpose
Migration Factory Agent is a deterministic, governed, and traceable application modernization platform.

Primary principles:

Deterministic execution first
Validation-driven modernization
Human governance
Knowledge-driven modernization
Incremental migrations
Complete traceability
Knowledge enrichment
AI is NOT the primary modernization mechanism.

AI is only used when reusable migration knowledge cannot resolve a migration scenario.

Technology Stack
Java 25
Spring Boot 4.x
Spring Framework 7.x
Maven
Picocli
Jackson
JUnit 5
JaCoCo
OpenRewrite
Architecture Rules
Follow Clean Architecture.

Package structure:

com.mfa

cli
application
domain
infrastructure
shared
Coding Rules
Prefer Java Records where appropriate
Constructor injection only
Avoid field injection
Avoid Lombok
Avoid static utility classes when a service is more appropriate
Keep domain model immutable
Add unit tests for all business logic
Important Constraints
Never introduce REST APIs
Never introduce databases
Never introduce messaging systems
Never introduce Spring MVC
Never introduce Spring Data
This application is a CLI application.

Assessment Engine Design
CLI ↓ AssessmentEngine ↓ Analyzers ↓ RepositoryInventory

Commands must not directly invoke multiple analyzers.

Always use the AssessmentEngine.

Build Validation
Before completing a task:

mvn clean verify

must complete successfully.

Fix compilation errors before considering the task complete.