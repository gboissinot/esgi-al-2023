# Step 18

## Description

- Restructure the Account Entity by domain events

## Details

- Use the EventSourcing Architecture Pattern

## Explanation

- Domain is enriched with new domain events : AccountCreated, AccountMoneyDeposited, AccountMoneyWithdrawn
- Entity creation and each entity business methods generate a domain event
- GetAccountBalanceService uses a read model with the AccountReadModel object
- AccountReadModel is created on demand
- AccountReadModel is populated with the Account's recorded events
- All recorded events are replayed for obtaining the balance value 
