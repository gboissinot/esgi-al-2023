# Step 12

## Description

- Introduce a bus layer

## Details

- Use a CommandBus and a QueryBus

## Explanation

- CommandBus and QueryBus are into the kernel
- AccountController has dependencies to commandBus and queryBus
- Bean validations is activated into the query and command bus
- Command and Query are only extension points : the validate() method is deleted.
- Command and Query objects doesn't call the validate() methods
