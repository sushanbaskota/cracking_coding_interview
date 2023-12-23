public class FibonacciTabulation {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fibTable = new int[n + 1];
        fibTable[0] = 0;
        fibTable[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibTable[i] = fibTable[i - 1] + fibTable[i - 2];
        }

        return fibTable[n];
    }

    public static void main(String[] args) {
        // Example usage:
        int n = 7;  // You can change this to any non-negative integer
        int result = fibonacci(n);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}
