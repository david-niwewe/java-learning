## **Improvements**

This project can be expanded collaboratively to strengthen understanding of **Java OOP**, **collections**, **exceptions**, and **software design principles**.  
Below are **10 suggested tasks**.

---

### **1. Add More Mathematical Operations**

**Description:**  
Implement additional operations such as:
- Logarithm (`log`, `ln`)
- Trigonometric inverses (`asin`, `acos`, `atan`)
- Exponential (`exp`)

**Learning Goals:**
- Extend `ScientificCalculator`
- Practice **method overriding** and **enums**
- Learn to use the **Java Math library**

---

### **2. Implement Custom Exceptions for Invalid Operations**

**Description:**  
Create and integrate specific custom exceptions:
- `NegativeFactorialException`
- `DivisionByZeroException`
- `OverflowException` (for large recursive operations)

**Learning Goals:**
- Understand **custom exception classes**
- Learn **throwing and handling** exceptions gracefully
- Improve **error traceability**

---

### **3. Refactor HistoryManager to Use Advanced Collections**

**Description:**  
Enhance the `HistoryManager` to:
- Use `LinkedList` for LRU-style history
- Use `Map<EOperation, List<HistoryRecord>>` to group history by operation

**Learning Goals:**
- Explore **Java Collections Framework** and **Generics**
- Apply **data organization** principles

---

### **4. Save & Load History to File**

**Description:**  
Add persistence to history:
- Save calculation history to `history.txt` or JSON
- Load it automatically on startup

**Learning Goals:**
- Work with **File I/O streams**
- Understand **serialization and deserialization**
- Handle **I/O exceptions**

---

### **5. Implement Undo/Redo Feature**

**Description:**  
Add undo/redo functionality using a **stack** to manage history states.

**Learning Goals:**
- Learn **Stack data structure**
- Manage **state transitions**
- Explore basic **design patterns**

---

### **6. Add CLI Menu Navigation**

**Description:**  
Improve the user interface with a structured CLI menu:
- Basic Operations
- Scientific Operations
- Advanced Operations
- History
- Exit

**Learning Goals:**
- Strengthen **control flow** logic
- Improve **user experience**
- Enhance **CLI modular design**

---

### **7. Input Validation Improvements**

**Description:**  
Enhance input validation to:
- Reject invalid symbols or strings
- Prevent overflow or nonsensical input

**Learning Goals:**
- Build **robust validation mechanisms**
- Handle **invalid input gracefully**
- Use **custom messages** for user feedback

---

### **8. Unit Testing with JUnit**

**Description:**  
Add **unit tests** for all calculator modules, covering:
- Edge cases (e.g., `0!`, `Fibonacci(1)`, division by zero)
- Scientific and advanced operations

**Learning Goals:**
- Learn **JUnit testing framework**
- Apply **Test-Driven Development (TDD)** principles
- Write **assertion-based tests**

---

### **9. Logging Integration**

**Description:**  
Integrate a logging framework (e.g., **SLF4J**, **Log4j**) to log:
- User inputs and results
- Errors and exceptions
- System actions

**Learning Goals:**
- Learn **logging best practices**
- Improve **debugging** and **traceability**
- Understand **log levels** (INFO, ERROR, DEBUG)

---

### **10. Refactor Project for Dependency Injection & SOLID Principles**

**Description:**  
Refactor project structure to:
- Use **constructor injection** for dependencies
- Apply **Interface Segregation** and **Dependency Inversion** principles

**Learning Goals:**
- Deepen understanding of **SOLID design**
- Learn **decoupling** and **interface-driven development**
- Improve **testability** and **scalability**

