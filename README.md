# Virtual Wallet - Backend Core (Java)

This is an active project currently in development. It simulates the core backend operations of a fintech virtual wallet. I am building and constantly expanding this system as I progress through my Java learning journey.

## Features Implemented (Phase 1)
* **User Management:** Registration with unique identifiers (CVU).
* **Financial Transactions:** Deposits and transfers using `BigDecimal` to ensure zero-loss financial precision.
* **In-Memory Data Storage:** Utilizing Java Collections API (`HashMap`, `ArrayList`) for fast data retrieval and relationship mapping.
* **Business Logic Security:** Strict validations against negative inputs, self-transfers, non-existent accounts, and insufficient funds.
* **Transaction History:** Immutable chronological record of all account movements utilizing OOP Inheritance.

## Next Steps (Roadmap)
* Refactor logic to incorporate Functional Programming (Streams & Lambdas).
* Implement Database persistence using JDBC.
* Evolve the architecture to a RESTful API using Spring Boot.