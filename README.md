##  Overview


- This repository demonstrates design patterns in Java, categorized as **Creational**, **Structural**, and **Behavioral**. 
  
- Each example includes a real-world inspired **use case**, clean implementation, and extensible design.

- And a simulation of a **Smart Office Facility** implemented in Java, demonstrating the use of three key design patterns:
  - **Singleton**
  - **Command**
  - **Observer**



---
##  Behavioral Patterns

### 1. Command Pattern – YouTube Player Actions
**Use Case:**  
Simulating a **YouTube Player** where buttons perform actions like Play, Pause, Rewind.  

**Description:**  
Simulates a **YouTube Player** where buttons perform actions like Play, Pause, and Rewind. The `YouTubeAppUI` serves as the invoker, binding commands to UI buttons, while `YouTubePlayer` acts as the receiver. This structure allows for flexible command execution

**Source:**  
[`exercise1.behaviour.command`](./src/exercise1/behaviour/command)

---

### 2. Null Object Pattern – YouTube Skip Ad(Additional Learning)
**Use Case:**  
Simulating a **YouTube Skip Ad button** that is **visible but inactive** for the first 5 seconds, then enabled.  

**Description:**  
Simulates a **Skip Ad button** that remains inactive for the first 5 seconds before becoming active. The `SkipAdButton` serves as the invoker, utilizing `NullCommand` for the inactive state and `SkipCommand` for the active state. This pattern simplifies handling of optional behaviors. 

**Source:**  
[`exercise1.behaviour.nullcommand`](./src/exercise1/behaviour/nullcommand)

---

### 3. Observer Pattern – ICU Patient Monitoring
**Use Case:**  
An **ICU Monitoring System** where doctors, nurses, and family are notified of changes in patient vitals.  

**Description:**  
An **ICU Monitoring System** that notifies doctors, nurses, and family of changes in patient vitals. The `ICUPatient` manages vital signs and observers, while concrete observers like `DoctorObserver` handle notifications. This pattern ensures timely updates on patient status.


**Source:**  
[`exercise1.behaviour.observer`](./src/exercise1/behaviour/observer)

---
##  Creational Patterns

### 1. Factory Pattern – Notification System
**Use Case:**  
A system that sends different types of notifications: **Email, SMS, Push**.  
The client requests a type, and the factory creates the correct notification object.

**Description:**  
A system that sends different types of notifications: **Email, SMS, Push**. The `NotificationFactory` encapsulates the creation logic, allowing clients to request notifications without knowing the specific classes. This promotes loose coupling and easier maintenance.
**Source:**  
[`exercise1.creational.factory`](./src/exercise1/creational/factory)

---

### 2. Builder Pattern – Event Management
**Use Case:**  
An **Event Management System** where events can have optional and mandatory fields (e.g., tech conference with full details, birthday party with minimal details).  

**Description:**  
An **Event Management System** that supports both optional and mandatory fields for events. The `EventBuilder` allows for step-by-step construction of complex `Event` objects, providing flexibility in event creation. This pattern enhances clarity and usability in object creation
.
**Source:**  
[`exercise1.creational.builder`](./src/exercise1/creational/builder)

---

##  Structural Patterns

### 1. Decorator Pattern – User Access Management
**Use Case:**  
A **User Access System** where roles (BasicUser, Editor, Admin) can be combined dynamically.  

**Description:**  
A **User Access System** that allows dynamic combination of roles like BasicUser, Editor, and Admin. The `Permission` component is enhanced by decorators such as `AdminAccess` and `EditorAccess`, which add capabilities like creating, deleting, and editing. This pattern enables flexible role management at runtime.


**Source:**  
[`exercise1.structural.decorator`](./src/exercise1/structural/decorator)

---

### 2. Facade Pattern – Travel Agent
**Use Case:**  
A **Travel Agent** that simplifies booking an overseas trip: handles **Visa, Tickets, Hotel, Transport, Sightseeing** behind one interface.  

**Description:**  
A **Travel Agent** that simplifies the process of booking an overseas trip by managing multiple subsystems like Visa, Tickets, Hotel, Transport, and Sightseeing under a single interface. The `TravelAgentFacade` provides a unified method, `bookOverseasTrip()`, allowing clients to book a trip with one call. This pattern streamlines complex interactions for ease of use.

**Source:**  
[`exercise1.structural.facade`](./src/exercise1/structural/facade)

---

## Smart Office Facility

This project is a simulation of a Smart Office Facility implemented in Java. It demonstrates the use of three key design patterns: Singleton, Command, and Observer.

### Key Features
- User authentication with role-based access control
- Room configuration and management
- Booking and cancellation of rooms
- Occupancy tracking
- Automatic cancellations based on inactivity
- Statistics and monitoring
- Email notifications for cancellations

### Design Patterns Used
- **Singleton**: For OfficeConfiguration, UserSession, and Logger
- **Command**: Encapsulates actions into individual command classes
- **Observer**: Notifies observers (ACController, LightController) on room state changes

### Technologies
- Java JDK 8 or higher
- Command-line interface for interaction

### Purpose
This project showcases clean, maintainable code using design patterns, handling real-world edge cases like concurrent bookings, invalid inputs, and role restrictions.

### Links
- [Project Repository on GitHub](https://github.com/NivasRenga03/EI_CampusDrive/tree/main/Smart_Office_Facility)
- [Detailed README](Smart_Office_Facility/README.md)
