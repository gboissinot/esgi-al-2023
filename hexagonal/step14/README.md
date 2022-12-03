# Step 14

## Description

- Reduces domain dependency

## Explanation

- Command and Query objects use only primitive types
- Domain exceptions are not propagated to the adapters
- Command and Query Bus have the responsibility to convert exceptions from the domain layers to application exceptions
- Controllers doesn't have domain dependencies : only application dependencies
- CommandHandler/QueryHandler generic types uses only wrapped primitive types or command/query objects 