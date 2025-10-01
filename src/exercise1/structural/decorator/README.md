## User Access Management – Decorator Design Pattern  

##  Use Case  
We simulate a **User Access System** where different users have varying permissions:  
- **BasicUser** → can only read content  
- **EditorAccess** → can read and edit content  
- **AdminAccess** → can read, create, and delete content  
- Users can have **multiple roles combined dynamically** (e.g., Admin + Editor)  

##  How the Use Case Aligns with the Pattern  
- **Component Interface** → `Permission` defines the `getAccess()` method  
- **Concrete Component** → `BasicUser` implements basic access  
- **Decorator** → `AccessDecorator` wraps a `Permission` object  
- **Concrete Decorators** → `AdminAccess`, `EditorAccess` extend permissions dynamically  
- **Client** → `Main` combines roles at runtime and prints resulting access rights  

##  Real-Life Scenario  
In a **Content Management System (CMS)**:  
1. A new employee starts with **BasicUser** (read-only).  
2. When promoted, the system adds **EditorAccess** dynamically, giving edit rights without changing the user class.  
3. An **Admin** or **Admin + Editor** gets combined permissions like create, delete, and edit, ensuring flexible access control.  


##  Benefits  
- Dynamically **adds responsibilities** without modifying existing classes  
- Supports **multiple role combinations** at runtime  
- Keeps code **maintainable and extensible** for future roles  
- Follows **Open/Closed Principle** → open for extension, closed for modification  

---

##  UML Diagram  
![Decorator UML](DecoratorUML.png)  
