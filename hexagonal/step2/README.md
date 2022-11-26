# Step 2

## Description

- Initialize Account management system domain model

## Details

- Add an Account domain object within the withdraw() and deposit() methods
- The Account's balance uses a BigDecimal
- We don't want to use events at this step for representing the Account balance

## Explanation

- An Account Entity is created
- Account uses a AccountID object as a Value Object ID
- AccountID uses directly a UUID type
- A Money Value Object is used to the Account balance
- Account Entity has two business methods : withdraw() and deposit()
- Business rules are into the Account Entity
- A domain exception AccountException is used
- AccountException is an unchecked exception