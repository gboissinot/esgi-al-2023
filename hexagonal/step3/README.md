# Step 3

## Description

- Provide the first business use case for sending money between two accounts

## Details

- Uses the following objects: AccountController, AccountService AccountRepository, InMemoryAccountRepository
- Add an Account Configuration object for the maximum transfer amount value

## Explanation

- AccountConfiguration object is a Configuration Object
- AccountConfiguration is implemented with a Java record
- AccountConfiguration is in the domain package
- AccountService is a simple Java application class with its sendMoney use case method
- AccountService has the responsibility to check the maximum amount value to transfer.
- AccountService uses an application exception.
- AccountId object is used for identified each account : avoid the usage of primitive obsession
- AccountRepository represents the extension point to the persistence layer
- AccountRepository is an output port
- AccountRepository has two minimal methods for retrieving the entity and saving the changes to the entity
- AccountRepository's findById() method throws an AccountException is the account is not found
- An application exception is used for convenience
- AccountController is a simple Java controller
- AccountController is an input adapter
- AccountController is the entry point of the application
- AccountController has a dependency to the AccountService object
- AccountController has the responsibility to handle application exceptions
