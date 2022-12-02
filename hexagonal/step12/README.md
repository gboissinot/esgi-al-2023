# Step 11

## Description

- Introduce a bus layer

## Details

- Use a CommandBus and a QueryBus

## Explanation

- AccountController has a dependency to commandBus and queryBus
- Command and Query are only extension points : the validate() method is deleted.
- Command and Query objects doesn't call the validate() methods
- Bean validations is activated into the query and command bus