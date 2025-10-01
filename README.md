##  Overview


- This repository demonstrates design patterns in Java, categorized as **Creational**, **Structural**, and **Behavioral**. 
  
- Each example includes a real-world inspired **use case**, clean implementation, and extensible design.

- And a simulation of a **Smart Office Facility** implemented in Java, demonstrating the use of three key design patterns:
  - **Singleton**
  - **Command**
  - **Observer**



---
## 🎭 Behavioral Patterns

### 1. Command Pattern – YouTube Player Actions
**Use Case:**  
Simulating a **YouTube Player** where buttons perform actions like Play, Pause, Rewind.  

**Description:**  
- **Invoker:** `YouTubeAppUI` – UI buttons  
- **Command Interface:** `Command`  
- **Concrete Commands:** `PlayCommand`, `PauseCommand`, `RewindCommand`  
- **Receiver:** `YouTubePlayer`  
- **Client:** `Main` – binds commands to UI buttons  

**Source:**  
[`exercise1.behaviour.command`](./src/exercise1/behaviour/command)

---

### 2. Null Object Pattern – YouTube Skip Ad(Additional Learning)
**Use Case:**  
Simulating a **YouTube Skip Ad button** that is **visible but inactive** for the first 5 seconds, then enabled.  

**Description:**  
- **Invoker:** `SkipAdButton`  
- **Command Interface:** `Command`  
- **Concrete Commands:** `NullCommand` (inactive), `SkipCommand` (active)  
- **Client:** `YouTubeAdDemo`  

**Source:**  
[`exercise1.behaviour.nullcommand`](./src/exercise1/behaviour/nullcommand)

---

### 3. Observer Pattern – ICU Patient Monitoring
**Use Case:**  
An **ICU Monitoring System** where doctors, nurses, and family are notified of changes in patient vitals.  

**Description:**  
- **Subject:** `ICUPatient` – manages vital signs and observers  
- **Observer Interface:** `ICUObserver`  
- **Concrete Observers:** `DoctorObserver`, `NurseObserver`, `FamilyObserver`  
- **Client:** `Main` – simulates patient condition changes  

**Source:**  
[`exercise1.behaviour.observer`](./src/exercise1/behaviour/observer)

---
## 🏗️ Creational Patterns

### 1. Factory Pattern – Notification System
**Use Case:**  
A system that sends different types of notifications: **Email, SMS, Push**.  
The client requests a type, and the factory creates the correct notification object.

**Description:**  
- **Product Interface:** `Notification`  
- **Concrete Products:** `EmailNotification`, `SMSNotification`, `PushNotification`  
- **Factory:** `NotificationFactory` – encapsulates object creation logic  
- **Client:** `Main` – requests notifications without knowing concrete classes  

**Source:**  
[`exercise1.creational.factory`](./src/exercise1/creational/factory)

---

### 2. Builder Pattern – Event Management
**Use Case:**  
An **Event Management System** where events can have optional and mandatory fields (e.g., tech conference with full details, birthday party with minimal details).  

**Description:**  
- **Product:** `Event` – complex object  
- **Builder:** `EventBuilder` – step-by-step construction  
- **Client:** `Main` – builds events with varying details  

**Source:**  
[`exercise1.creational.builder`](./src/exercise1/creational/builder)

---

## 🏛️ Structural Patterns

### 1. Decorator Pattern – User Access Management
**Use Case:**  
A **User Access System** where roles (BasicUser, Editor, Admin) can be combined dynamically.  

**Description:**  
- **Component:** `Permission`  
- **Concrete Component:** `BasicUser` (read access)  
- **Decorators:** `AdminAccess`, `EditorAccess` (add create, delete, edit dynamically)  
- **Client:** `Main` – composes roles at runtime  

**Source:**  
[`exercise1.structural.decorator`](./src/exercise1/structural/decorator)

---

### 2. Facade Pattern – Travel Agent
**Use Case:**  
A **Travel Agent** that simplifies booking an overseas trip: handles **Visa, Tickets, Hotel, Transport, Sightseeing** behind one interface.  

**Description:**  
- **Subsystems:** `VisaProcessing`, `TicketBooking`, `Lodging`, `LocalTransport`, `SightSeeing`  
- **Facade:** `TravelAgentFacade` – provides a single unified method `bookOverseasTrip()`  
- **Client:** `Main` – books a trip in one call  

**Source:**  
[`exercise1.structural.facade`](./src/exercise1/structural/facade)

---

## 🏢 Smart Office Facility

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
- [Design Patterns and Usage Guide](DesignPatterns_and_Usage.md)
