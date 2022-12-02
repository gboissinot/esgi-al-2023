# Step 7

## Description

- Apply the Interface Segregation Principle for application services

## Details

- Add CreateAccountService and SendMoneyService objects

## Explanation

- CreateAccountService implements the CreateAccountUseCase
- SendMoneyService implements the SendMoneyUseCase
- AccountService has been deleted
- No impact for the AccountController : the controller uses only the use case interfaces
