# Step 4

## Description

- Provide the business use case of the account creation

## Explanation

- AccountRepository has the nextId() method
- InMemoryAccountRepository is modified in order to add the nextId() method implementation
- AccountService has the new business use case with the createAccount method
- AccountController reflects the AccountService granularity
- No new projet class is created