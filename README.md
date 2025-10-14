# CLI Scientific Calculator in Java

A **Command Line Interface (CLI) Scientific Calculator** implemented in Java using Maven.  
This project demonstrates **core Java programming**, **object-oriented programming (OOP) principles**, **input validation**, and **robust exception handling**.

---

## **Table of Contents**

1. [Features](#features)
2. [Learning Goals](#learning-goals)
3. [OOP Principles Applied](#oop-principles-applied)
4. [Programming Best Practices](#programming-best-practices)
5. [Usage](#usage)
    - [Compiling](#compiling)
    - [Running](#running)
---

## **Features**

- Basic arithmetic: `+`, `-`, `*`, `/`
- Scientific operations: `^` (power), `sqrt` (square root), `sin`, `cos`, `tan`
- Robust **input validation** for numbers and operations
- Exception handling for invalid operations and division by zero
- User-friendly **repeating calculation loop**

---

## **Learning Goals**

This project helps you learn:

- Java **interfaces** and **abstract contracts**
- Class **inheritance** and **method overriding**
- **Polymorphism**: using a single variable for multiple implementations
- **Enums** to represent operations safely
- Exception handling and input validation
- CLI application structure in Java
- Separation of concerns and clean coding practices

---

## **OOP Principles Applied**

| Principle | How It’s Used |
|-----------|---------------|
| **Abstraction** | `Calculator` interface defines the `calculate()` method. Users don't need to know implementation details. |
| **Encapsulation** | Classes hide internal logic. `BasicCalculator` and `ScientificCalculator` handle their own operations. |
| **Inheritance** | `ScientificCalculator` extends `BasicCalculator` to reuse and extend functionality. |
| **Polymorphism** | `Calculator calculator = new ScientificCalculator();` lets the code call `calculate()` without knowing the exact implementation. |
| **Single Responsibility** | Separate classes for basic and scientific calculations; separate methods for input validation. |
| **Open/Closed Principle** | Easy to add new operations without modifying existing code. |
| **Delegation** | `BasicCalculator` delegates unknown operations to `ScientificCalculator` when needed. |

---

## **Programming Best Practices**

- **Input validation**: Ensures numbers and operators are valid before calculations.
- **Exception handling**: Provides informative error messages for invalid operations and division by zero.
- **DRY principle**: Reuses `BasicCalculator` operations in `ScientificCalculator`.
- **Clean, readable code**: Meaningful method names, proper indentation, and Javadoc documentation.
- **Extensibility**: New operations can be added to the `Operation` enum and `ScientificCalculator`.

---

## **Usage**

### **1. Compiling**

Ensure you have Java installed (JDK 8+ recommended).  
Open a terminal in the project directory and run:

```bash
mvn compile

```
### **2. Running**
After compilation use the command below to run the application.
```bash
mvn exec:java -Dexec.mainClass="com.calculator.app.CalculatorApp"
```