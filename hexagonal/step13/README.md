# Step 13

## Description

- Reduces domain dependency

## Explanation

- Command and Query objects use only primitive types
- Domain exceptions are not propagated to the adapters
- Command and Query bus implementations have the responsibility to convert exceptions from the domain layers to
  application exceptions