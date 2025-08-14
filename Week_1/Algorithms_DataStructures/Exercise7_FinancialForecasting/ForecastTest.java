package Algorithms_DataStructures.Exercise7_FinancialForecasting;

public class ForecastTest {
    public static void main(String[] args) {
        double currentValue = 10000; // initial investment
        double growthRate = 0.08;    // 8% annual growth
        int years = 5;

        double futureValueRecursive = FinancialForecast.forecast(currentValue, growthRate, years);
        double futureValueIterative = FinancialForecast.forecastIterative(currentValue, growthRate, years);

        System.out.printf("Recursive Forecast: ₹%.2f%n", futureValueRecursive);
        System.out.printf("Iterative Forecast: ₹%.2f%n", futureValueIterative);
    }
}
