# Step 17

## Description

- Add a Notification service

## Details

- Use events for decoupling tasks

## Explanation

- Notifications is an external output port
- LogNotifications is an output adapter port of the Notifications port
- Event, EventDispatcher and EventHandler are new interfaces into the kernel for event management
- AccountCreatedEvent and TransferAcceptedEvent are two applications events
- Application events are used for executing external tasks (event handlers)
- AccountCreatedEvent is dispatched from CreateAccountService
- TransferAcceptedEvent is dispatched from SendMoneyService
- AccountCreatedEventHandler has the responsibility to handle AccountCreatedEvent event
- TransferAcceptedEventHandler has the responsibility to handle TransferAcceptedEvent event
- ApplicationConfiguration is updated with the new Spring beans