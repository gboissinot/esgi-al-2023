# Step 11

## Description

- Introduce a bus layer

## Details

- Use a CommandBus and a QueryBus from a Kernel

## Explanation

- AccountController has a dependency to commandBus and queryBus
- Command use cases follows the CommandHandler interface
- Query use case follows the QueryHandler interface
- Command and Query are only extension point. The validate() method is deleted.