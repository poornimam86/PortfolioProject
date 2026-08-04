# Lab 6 – Concurrent Collections (ConcurrentHashMap)

## Objective
To implement thread-safe collections using ConcurrentHashMap and demonstrate concurrent stock price updates using multiple threads.

## Concepts Covered
- ConcurrentHashMap
- Runnable Interface
- Thread Creation
- Thread Synchronization using join()
- Thread-safe Updates
- JUnit Testing

## Files Added
- ConcurrentPortfolio.java
- PriceUpdater.java
- ConcurrentDemo.java
- ConcurrentPortfolioTest.java
- HashMapRaceConditionTest.java

## Sample Output

===== Before Price Update =====

TCS       ₹3400.00
Infosys   ₹1800.00
Wipro      ₹550.00

Thread-0 updated TCS
Thread-1 updated Infosys
Thread-2 updated Wipro

===== After Price Update =====

TCS       ₹3500.00
Infosys   ₹1900.00
Wipro      ₹600.00

## Learning Outcome
Implemented thread-safe stock price updates using ConcurrentHashMap and verified correctness with JUnit tests.
