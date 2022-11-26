# Step 8

## Description

- Apply the Interface Segregation Pattern for output ports

## Details

- Add CreateAccountPort, LoadAccountPort, UpdateAccountStatePort objects

## Explanation

- CreateAccountPort, LoadAccountPort, UpdateAccountStatePort are persistence output ports
- CreateAccountPort, LoadAccountPort, UpdateAccountStatePort are interfaces
- CreateAccountPort has the nextId() and save() methods
- LoadAccountPort has the load() method
- UpdateAccountStatePort has the update() method
- AccountPersistenceAdapter implements the persistence output ports
- SendMoneyService have two dependencies : LoadAccountPort and UpdateAccountStatePort
