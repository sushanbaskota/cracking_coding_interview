import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        // System.out.println(fibonacci_recursive(6)); // 1 1 2 3 5 8 13 21
        System.out.println(fibonacci_DP(6L, new HashMap<>())); // 1 1 2 3 5 8
        // System.out.println(fibonacci_DP(50L, new HashMap<>())); // 1 1 2 3 5 8
    }

    private static long fibonacci_recursive(int n) {
        if (n <= 2) {
            return 1;
        }

        long a = fibonacci_recursive(n - 1);

        long b = fibonacci_recursive(n - 2);

        return a + b;
    }

    private static long fibonacci_DP(Long n, Map<Long, Long> memoMap) {
        if (memoMap.containsKey(n)) {
            return memoMap.get(n);
        }
        if (n <= 2) {
            return 1;
        }

        long a = fibonacci_DP(n - 1, memoMap);

        long b = fibonacci_DP(n - 2, memoMap);

        long fib = a + b;

        memoMap.put(n, fib);

        return memoMap.get(n);
    }
}
