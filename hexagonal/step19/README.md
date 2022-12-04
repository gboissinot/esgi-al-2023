# Step 19

## Description

- Adapt to an Onion Architecture

## Explanation

- Top layers has been refactored with application,domain, exposition, infrastructure
- Accounts repository replaces LoadAccountPort, CreateAccountPort, UpdateAccountStatePort
- Domain layers contains the Accounts repository
- Accounts is the repository with two implementations JPAAccounts and InMemoryAccounts
- All previous output adapters are placed into the infrastructure layer

