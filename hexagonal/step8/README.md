# Step 8

## Description

- Apply the Interface Segregation Principle for output ports

## Details

- Add CreateAccountPort, LoadAccountPort, UpdateAccountStatePort objects

## Explanation

- CreateAccountPort, LoadAccountPort, UpdateAccountStatePort are persistence output ports
- CreateAccountPort, LoadAccountPort, UpdateAccountStatePort are interfaces
- CreateAccountPort has the nextId() and save() methods
- LoadAccountPort has the load() method
- UpdateAccountStatePort has the update() method
- InMemoryAccountPersistenceAdapter implements all the persistence output ports
- SendMoneyService has only two dependencies : LoadAccountPort and UpdateAccountStatePort
- CreateAccountService has only CreateAccountPort as dependency
