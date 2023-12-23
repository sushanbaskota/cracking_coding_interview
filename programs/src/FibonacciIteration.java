public class FibonacciIteration {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int fibNMinus2 = 0;
        int fibNMinus1 = 1;
        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibNMinus1 + fibNMinus2;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibN;
        }

        return fibN;
    }

    public static void main(String[] args) {
        // Example usage:
        int n = 7;  // You can change this to any non-negative integer
        int result = fibonacci(n);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}
