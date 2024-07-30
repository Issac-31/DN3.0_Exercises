public class FinancialForecasting {

    /**
     * Recursive method to calculate future value.
     *
     * @param presentValue The initial value.
     * @param growthRate The growth rate per period (as a decimal).
     * @param periods The number of periods.
     * @return The future value.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base Case: If no periods are left, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive Case: Apply the growth rate and reduce the number of periods
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }
    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial amount
        double growthRate = 0.05;     // Growth rate of 5%
        int periods = 10;             // No. of. periods

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("The future value after %d periods is: $%.2f%n", periods, futureValue);
    }
}
