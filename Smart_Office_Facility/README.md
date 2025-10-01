# Smart Office Facility

## Overview

This project is an Smart Office Facility that allows users to manage room bookings, configure office settings, and monitor room statuses. The system uses several design patterns, including Singleton, Command, and Observer patterns, to ensure a scalable and maintainable architecture.

## Design Patterns

### Singleton Pattern

The Singleton pattern is used to ensure that certain classes have only one instance throughout the application. This is particularly useful for managing shared resources or configurations.

- **[`OfficeConfiguration`](src/models/OfficeConfiguration.java)**: Manages office settings and configurations.
- **[`UserSession`](src/models/UserSession.java)**: Manages user session information.
- **[`Logger`](src/utils/Logger.java)**: Central logging utility.

### Command Pattern

The Command pattern is used to encapsulate all the information needed to perform an action or trigger an event. This pattern is useful for implementing undo/redo functionality, logging changes, and more.

Available commands:
- **[`AddOccupantCommand`](src/commands/AddOccupantCommand.java)**: Adds an occupant to a room.
- **[`BlockRoomCommand`](src/commands/BlockRoomCommand.java)**: Blocks a room.
- **[`CancelRoomCommand`](src/commands/CancelRoomCommand.java)**: Cancels a room booking.
- **[`ConfigReleaseDelayCommand`](src/commands/ConfigReleaseDelayCommand.java)**: Configures the release delay for automatic cancellations.
- **[`ConfigRoomCommand`](src/commands/ConfigRoomCommand.java)**: Configures room settings.
- **[`ConfigRoomMaxCapacityCommand`](src/commands/ConfigRoomMaxCapacityCommand.java)**: Configures the maximum capacity of a room.
- **[`OfficeStatisticsCommand`](src/commands/OfficeStatisticsCommand.java)**: Retrieves office statistics.
- **[`RemoveOccupantCommand`](src/commands/RemoveOccupantCommand.java)**: Removes occupants from a room.
- **[`RoomStatusCommand`](src/commands/RoomStatusCommand.java)**: Checks the status of a room.
- **[`UserAuthenticationCommand`](src/commands/UserAuthenticationCommand.java)**: Authenticates a user.

### Observer Pattern

The Observer pattern is used to notify multiple objects about changes in the state of another object. This pattern is useful for implementing distributed event handling systems.

- **[`RoomObserver`](src/observers/RoomObserver.java)**: Observes changes in room status and updates accordingly.
- **[`ACController`](src/observers/ACController.java)**: Controls the air conditioning based on room status.
- **[`LightController`](src/observers/LightController.java)**: Controls the lighting based on room status.

## Features

### User Authentication

User authentication is handled by the [`UserAuthenticationCommand`](src/commands/UserAuthenticationCommand.java). This command verifies user credentials and manages user sessions.

### Email Notifications

Email notifications are sent using the [`Email`](src/models/Email.java) class. Notifications are triggered for various events, such as booking cancellations due to inactivity.

### Automatic Cancellations

The system automatically cancels room bookings if the room is unoccupied for a specified period. This is handled by the [`Booking`](src/models/Booking.java) class, which checks the room status and notifies users of cancellations.

### Command Parsing

Commands are parsed and executed using the [`CommandParser`](src/utils/CommandParser.java) class. This class imports all available commands and provides a mechanism to execute them based on user input.

## Edge Cases

The system manages rare but critical scenarios, including:

- Concurrent booking conflict resolution.
- Role-based permission checks for configuration and booking actions.
- Invalid booking time ranges (crossing midnight, in the past).
- Occupancy constraints (e.g., insufficient occupants <2 to mark occupied).
- Room reconfiguration prevented if active bookings exist.
- Adding occupants to unbooked or unconfigured rooms.
- Unauthorized cancellation of others’ bookings.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/NivasRenga03/EI_CampusDrive/edit/main/Smart_Office_Facility
    ```
2. Navigate to the project directory:
    ```sh
    cd 'Smart_Office_Facility'
    ```

### Running the Application

To compile the application, run:

```sh
javac -d out -cp . src/models/*.java src/commands/*.java src/obs
```

To start the application, run:
```sh
java -cp out src.Main
```

## Inputs

The application accepts the following inputs:

### Login Commands

To login, enter the following command:

```sh
Login <username>
```

To logout, enter the following command:

```sh
Logout
```

To retrieve the current user's role, enter the following command:

```sh
Me
```

### Room Configuration Commands

To configure the number of rooms, enter the following command:

```sh
Config room count <count>
```

To configure the maximum capacity of a room, enter the following command:

```sh
Config room max capacity <room_id> <capacity>
```

To configure the release delay for automatic cancellations, enter the following command:

```sh
Config release delay <millis>
```

### Room Occupancy Commands

To add occupants to a room, enter the following command:

```sh
Add occupant <room_id> <count>
```

To remove occupants from a room, enter the following command:

```sh
Remove occupant <room_id> <count>
```

### Room Booking Commands

To block a room, enter the following command:

```sh
Block room <room_id> <time> <duration>
```

To cancel a room booking, enter the following command:

```sh
Cancel room <room_id> <booking_id>
```

### Room Status and Statistics Commands

To check the status of a room, enter the following command:

```sh
Status room <room_id>
```

To retrieve office statistics, enter the following command:

```sh
Statistics
```

lid inputs as splays a message indicating that the room has been blocked successfully.
- Cancel Room: Displays a message indicating that the room booking has been cancelled successfully.
- Configure Release Delay: Displays a message indicating that the auto-release delay has been set successfully.
- Remove Occupants: Displays a message indicating that the occupants have been removed successfully.
- Status Room: Displays the status of a room.
- Statistics: Displays the office statistics.

## Error Handling

The system displays user-friendly error messages for:

- Room count (non-positive).
- Capacity (negative).
- Time format (HH:mm:ss).
- Duration (negative or zero).
- Room ID (non-existent).
- Command (unknown).
- Command format (wrong number of arguments).
- Role (not admin or user).
- Negative occupant counts.
- Adding occupants to unbooked rooms.
- Max capacity not configured before adding occupants.
- Room reconfiguration blocked if rooms have active bookings.
- Insufficient occupants (<2) to mark room as occupied.
- Booking ID not found.
- Overlapping bookings.
- Notification/email delivery failures.

## Conclusion

This project demonstrates the implementation of a Smart Office Facility using Java and the design patterns. The system allows users to configure rooms, add and remove occupants, block rooms, and cancel bookings. It also provides notifications for booking cancellations due to inactivity and automatically cancels bookings if the room is unoccupied for a specified period. The system handles concurrent booking requests and logs any failures in sending email notifications. The application is built using the Java programming language and the design patterns, including the Singleton, Command, and Observer patterns.

