# Step 9

## Description

- Add an ACL layer for validating input commands

## Details

- Introduce Bean validations Java library

## Explanation

- CreateAccountCommand and SendMoneyCommand uses the bean validation annotations
- Command objects have the responsibility to apply syntactic validations
- Command object objects implements the Command extension point
- Each command creation calls validate() method into the interface (default method)
- Command default method validate() use the Validator collaboration object for validating commands
- A kernel package brings common concern
