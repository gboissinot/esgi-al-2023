# Step 1

## Description

- Initialize the project structure for supporting a Hexagonal architecture

## Notes

- Many Java structures are possible
- We have chosen to have a code model aligned to the architecture model

## Remember

- Domain contains core domain objects (such as entities, value objects, domain services, value objects id)
- Domain contains business rules
- Domain is the more stable part of the project
- Application contains use cases and its service implementations
- Application uses domain objects
- An input port represents a use case
- An output port correspond is an external extension point in order to invoke external concerns
- The Dependency Inversion Principle (DIP) is applied for the output port (an abstraction by an interface is used)
- A service class is the implementation of the use case

## Explanation

- A module is implemented by a Java package
- 3 top packages : adapter, application, domain
- /domain is a dedicated package for domain objects
- /application encapsulates all application concern with /port extension points and /services implementation classes
- application/port/in contains only interfaces for each use cases
- application/port/out contains only interfaces for external services
