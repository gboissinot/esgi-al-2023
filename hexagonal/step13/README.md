# Step 13

## Description

- Add a REST Web Controller

## Details

- Uses Spring Boot Web library

## Explanation

- The web controller is an input port
- AccountWebController is the entry point for web requests
- CreateAccountRequest, CreateAccountResponse, TransferAccountRequest, GetBalanceResponse are the Web model
- Web model uses also the bean validation
- The web controller has the responsibility to invoke commands and query through the command bus and query bus
- Application is the Spring boot entry point
- ApplicationConfiguration uses Java Config for configuration all Spring beans : Direct Spring annotations is avoided
  into the application layer