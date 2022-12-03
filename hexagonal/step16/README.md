# Step 16

## Description

- Replace the in memory persistence with a JPA

## Explanation

- AccountEntity is a JPA entity
- AccountEntityRepository is the JPA Account Entity Repository
- AccountEntityRepository is an interface and extends the JPA Repository CrudRepository
- A dynamic implementation of AccountEntityRepository is injected by Spring Data JPA at boot-time
- AccountPersistenceAdapter has a dependency to AccountEntityRepository