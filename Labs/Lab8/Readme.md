# Lab 8 – JVM Profiling & Memory Leak Detection

## Objective

Identify a memory leak caused by an unbounded static trade history and fix it by limiting the history size.

## Concepts Covered

- JVM Memory
- Garbage Collection
- Static Objects
- Memory Leak
- Heap Profiling
- VisualVM (to be demonstrated)

## Files

- Trade.java
- TradeHistory.java
- MemoryLeakDemo.java
- TradeHistoryTest.java

## Before Fix

Trade history kept growing.

```
Trades Stored : 10000
Trades Stored : 20000
...
Trades Stored : 100000
```

## After Fix

Trade history is limited to 1000 records.

```
Trades Stored : 1000
Trades Stored : 1000
...
Trades Stored : 1000
```

## Learning Outcome

Implemented a bounded trade history to prevent unbounded memory growth and prepared the application for JVM profiling using VisualVM.
