 # Exercise 7: Financial Forecasting

## Objective
Predict future value based on past data using recursion.

## Forecast Formula
Future Value = Current Value × (1 + growthRate) ^ years

## Recursive Method
- Repeatedly multiplies current value with (1 + growthRate)
- Base case: if years = 0, return current value

## Iterative Optimization
- Loop-based approach avoids stack overflow
- Better for large `years` values

## Example Output
Recursive Forecast: ₹14693.28
Iterative Forecast: ₹14693.28

## Time Complexity
- Recursive: O(n)
- Iterative: O(n) but more efficient in memory

## Conclusion
Recursion is elegant but limited by stack size. Iteration is preferred in production.
