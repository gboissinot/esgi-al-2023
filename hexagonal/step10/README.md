# Step 10

## Description

- Add Get query balance use case

## Details

- Add the GetAccountBalanceUseCase, AccountBalanceQuery and GetAccountBalanceService objects

## Explanation

- A Query extension point into the kernel is added, it is an interface
- GetAccountBalanceUseCase is an input port
- AccountBalanceQuery is a DTO
- AccountBalanceQuery properties are validated with bean validation
- GetAccountBalanceService is an application service
- GetAccountBalanceService implements GetAccountBalanceUseCase