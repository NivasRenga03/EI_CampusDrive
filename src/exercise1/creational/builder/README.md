# 🏗️ Event Builder – Builder Pattern  

## 🎯 Use Case  
We simulate an **Event Management System** where events can have varying levels of details:  

- Some events have all details: name, date, venue, speaker, and capacity.  
- Other events may have only mandatory details like name and date, while optional details can be added later.  

The **Builder Pattern** provides a flexible way to handle these variations without creating multiple constructors.  

---

## 🔗 How the Use Case Aligns with the Pattern  

- **Product** → `Event` (the complex object being built)  
- **Builder** → `EventBuilder` (constructs an `Event` step by step, supports optional parameters fluently)  
- **Client** → `Main` (uses the builder to create events like conferences, parties, etc.)  

---

## 💡 Real-Life Scenario  

1. An organizer schedules a **Tech Conference** with complete details (venue, speaker, capacity, etc.).  
2. A **Birthday Party** only has basic details set (name, date, and venue), leaving optional details unset.  
3. Using the Builder Pattern, both events can be created **without multiple overloaded constructors** while keeping the code clean.  

---

## ✨ Benefits  

- **Simplifies Object Creation** → No need for multiple constructors.  
- **Improves Readability** → Code becomes more descriptive and self-explanatory.  
- **Supports Optional Parameters** → Only set values that matter, skip the rest.  
- **Immutable Objects** → Ensures created objects are consistent and safe.  
- **Flexibility** → Easy to extend by adding new optional fields without breaking existing code.  

---

## 🖥️ UML Diagram  
![Builder UML](BuilderUML.jpg)  
