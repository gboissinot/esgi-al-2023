# Step 14

## Description

- Replace the in memory persistence with a JPA

## Explanation

- AccountEntity is a JPA entity
- AccountRepository is JPA Repository
- AccountRepository is an interface and extends the JPA Repository CrudRepository
- A dynamic implementation to AccountRepository is injected by Spring Data JPA at boot-time
- AccountPersistenceAdapter has a dependency to AccountRepository