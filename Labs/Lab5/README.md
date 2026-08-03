# Week 05 – Lab 5: Multithreading using Runnable

## Aim
To implement multithreading using the Runnable interface for automatic stock price updates.

## Theory
The Runnable interface enables concurrent execution of tasks. A background thread continuously updates stock prices while allowing users to interact with the application.

## Concepts Used
- Runnable Interface
- Thread Class
- Background Processing
- Multithreading

## Files Modified
- PriceFeedSimulator.java
- Stock.java
- Main.java

## Algorithm
1. Create a Runnable class.
2. Update stock prices every two seconds.
3. Generate ±5% random price variation.
4. Start the background thread.
5. Verify user input remains responsive.

## Expected Output
- Live stock price updates
- Responsive menu
- Background thread execution

## Conclusion
Successfully implemented multithreading using Runnable for live stock price simulation.
