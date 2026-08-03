# Week 04 – Lab 4: Generics + File I/O using Jackson

## Aim
To implement a generic class `DataStore<T>` for saving and loading Portfolio and User objects using Jackson JSON serialization and handle file operations using exception handling.

## Theory
Generics enable reusable and type-safe classes, while Jackson converts Java objects into JSON format and vice versa. JSON persistence allows application data to remain available even after the application is restarted.

## Concepts Used
- Java Generics
- Jackson ObjectMapper
- JSON Serialization & Deserialization
- File I/O
- Exception Handling (IOException)

## Files Modified
- DataStore.java
- Portfolio.java
- User.java
- PortfolioService.java
- Main.java

## Algorithm
1. Create a generic class `DataStore<T>`.
2. Save Portfolio and User objects into JSON files.
3. Load data from JSON during application startup.
4. Handle IOException using try-catch.
5. Verify data persistence after restarting the application.

## Expected Output
- Save Portfolio to JSON
- Load Portfolio from JSON
- Data persists after application restart

## Conclusion
Successfully implemented generic JSON persistence using Jackson to store and retrieve portfolio information.
