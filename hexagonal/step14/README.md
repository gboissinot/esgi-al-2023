# Step 14

## Description

- Reduces domain dependencies

## Explanation

- Command and Query objects use only primitive types
- Controllers doesn't have domain dependencies : only application dependencies
- CommandHandler/QueryHandler generic types uses only wrapped primitive types or command/query objects 
- Domain model represents the internal model
- Exposition Model such as *Request/*Response represents a pivot model (a common model for many consumer use cases)
- Domain exceptions are not propagated to the adapters
- Command and Query Bus have the responsibility to convert exceptions from the domain layers to application exceptions
- An ApplicationException has been added to the kernel
- WebController handles ApplicationException exception for users
- AccountApplicationException extends ApplicationException
