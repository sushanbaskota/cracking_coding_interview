import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    public static int climbStairs(int n) {
        return climbStairs_DP(n, new HashMap<>());
    }

    public static int climbStairs_DP(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int ways = climbStairs_DP(n - 1, memo) + climbStairs_DP(n - 2, memo);

        memo.put(n, ways);

        return memo.get(n);
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(44));
    }
}
