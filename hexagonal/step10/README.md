# Step 10

## Description

- Add a query balance use case

## Details

- Add the GetAccountBalanceUseCase, AccountBalanceQuery and GetAccountBalanceService objects

## Explanation

- A new Query extension point (as an interface) is added into the kernel.
- GetAccountBalanceUseCase is an input port
- AccountBalanceQuery is a DTO
- AccountBalanceQuery properties are validated with bean validation
- GetAccountBalanceService is an application service
- GetAccountBalanceService implements GetAccountBalanceUseCase
- Command and Query default validator uses the common UseCaseValidator object
- The new GetAccountBalanceUseCase is used into the AccountController