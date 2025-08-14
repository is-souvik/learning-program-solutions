package Algorithms_DataStructures.Exercise7_FinancialForecasting;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecast(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized version using iteration (avoiding recursion overhead)
    public static double forecastIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }
}
