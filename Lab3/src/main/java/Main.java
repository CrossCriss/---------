public class Main {
    public static void main(String[] args) {
        // Factorial calculation
        int n = 5;
        long factorialCycle = FactorialCalculator.cycleExecute(n);
        long factorialRecursion = FactorialCalculator.recursionExecute(n);
        System.out.println("Factorial of " + n + ": " + factorialCycle);
        assert factorialCycle == factorialRecursion : "Different values";

        // Fibonacci calculation
        int fibN = 10;
        int fibCycle = FibonacciCalculator.cycleExecute(fibN);
        int fibRecursion = FibonacciCalculator.recursionExecute(fibN);
        System.out.println("Fibonacci number at index " + fibN + ": " + fibCycle);
        assert fibCycle == fibRecursion : "Different values";

        // Digit sum calculation
        int num = 12345;
        int digitSum = DigitSumCalculator.execute(num);
        System.out.println("Sum of digits in " + num + ": " + digitSum);

        // Sum of two numbers calculation
        int a = 5;
        int b = 7;
        int sum = SumCalculator.execute(a, b);
        System.out.println("Sum of " + a + " and " + b + ": " + sum);
    }
}
