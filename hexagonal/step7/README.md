# Step 7

## Description

- Apply the Interface Segregation Principle for application services

## Details

- Add CreateAccountService and SendMoneyService objects

## Explanation

- CreateAccountService implements the CreateAccountUseCase
- SendMoneyService implements the SendMoneyUseCase
- Each service has only one responsibility
- The AccountService class has been deleted
- AccountController is not modified : the controller uses only the use case interfaces
