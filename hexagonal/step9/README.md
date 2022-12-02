# Step 9

## Description

- Add an Anti Corruption Layer (ACL) for validating input commands

## Details

- Introduce Bean validations Java library

## Explanation

- CreateAccountCommand and SendMoneyCommand uses the bean validation library
- Command objects have the responsibility to apply syntactic validations
- Command object objects implements the Command extension point (interface)
- Each command creation calls validate() method into the interface (default method)
- Command default method validate() use the Validator collaboration object for validating commands
- A kernel package supports all common concern
- SendMoneyCommand construction continues to check by code the positive value of initialAmount because @Positive bean
  validation annotation doesn't work for value object 
