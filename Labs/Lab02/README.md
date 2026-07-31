# Lab 2 – Polymorphism in Portfolio Management System

## Aim

To implement Object-Oriented Programming concepts such as Inheritance, Abstraction, Method Overriding, and Runtime Polymorphism in the Portfolio Management System.

---

## Theory

Polymorphism allows a single interface to represent different implementations. Runtime polymorphism is achieved using method overriding, where the method to execute is decided during program execution.

In this lab:

- Asset was converted into an abstract class.
- Stock extends Asset.
- The calculateCurrentValue() method was declared abstract in Asset and overridden in Stock.
- Portfolio stores Asset objects and calculates the total portfolio value using dynamic dispatch.
- CRUD operations from Lab 1 were retained.

---

## OOP Concepts Used

- Abstraction
- Inheritance
- Method Overriding
- Runtime Polymorphism (Dynamic Dispatch)
- ArrayList Collection

---

## Files Modified

- Asset.java
- Stock.java
- Portfolio.java
- PortfolioService.java
- Main.java

---

## Algorithm

1. Create an abstract Asset class.
2. Extend Asset using the Stock class.
3. Override calculateCurrentValue() in Stock.
4. Store Asset objects in Portfolio.
5. Calculate the total portfolio value using polymorphism.
6. Perform Add, Display, Search, Update, and Delete operations.

---

## Expected Output

- Add Stock
- Display Stock
- Search Stock
- Update Stock
- Delete Stock
- Display Total Portfolio Value

---

## Conclusion

Successfully implemented runtime polymorphism by overriding methods and using Asset references to manage Stock objects. The Portfolio Management System was enhanced while preserving the functionality developed in Lab 1.
