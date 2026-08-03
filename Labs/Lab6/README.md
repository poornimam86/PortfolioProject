# Week 06 – Lab 6: Concurrent Collections

## Aim
To improve thread safety using ConcurrentHashMap and AtomicInteger.

## Theory
ConcurrentHashMap enables safe concurrent access without explicit synchronization, while AtomicInteger provides thread-safe counting operations.

## Concepts Used
- ConcurrentHashMap
- AtomicInteger
- Thread Safety
- Concurrent Programming

## Files Modified
- PortfolioService.java
- Portfolio.java
- ThreadTest.java

## Algorithm
1. Replace HashMap with ConcurrentHashMap.
2. Create multiple reader threads.
3. Update shared data concurrently.
4. Count operations using AtomicInteger.
5. Verify exception-free execution.

## Expected Output
- Safe concurrent execution
- No ConcurrentModificationException
- Correct thread-safe output

## Conclusion
Successfully implemented concurrent collections for thread-safe portfolio management.
