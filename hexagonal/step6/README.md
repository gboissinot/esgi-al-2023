# Step 6

## Description

- Add use case extension points

## Details

- Add CreateAccountUseCase and SendMoneyUseCase input port

## Explanation

- CreateAccountUseCase and SendMoneyUseCase are interfaces
- AccountService implements the both use cases
- Commands objects are input for the use cases methods
- AccountController uses the both use cases by dependency injection