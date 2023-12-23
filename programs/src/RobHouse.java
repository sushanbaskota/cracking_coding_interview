import java.util.HashMap;
import java.util.Map;

public class RobHouse {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1})); //4
        System.out.println(rob(new int[]{2, 7, 9, 3, 1})); //12
        System.out.println(rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90,
                222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240})); //4173
    }

    public static int rob(int[] nums) {
        return rob_DP_Memo(nums, nums.length - 1, new HashMap<>());
    }

    public static int rob_DP(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        int currentHouseMoney = nums[i];

        return Math.max(rob_DP(nums, i - 2) + currentHouseMoney, rob_DP(nums, i - 1));
    }

    public int rob_DP_Memo(int[] nums, int i, Map<Integer, Integer> memoMap) {
        if (memoMap.containsKey(i)) {
            return memoMap.get(i);
        }
        if (i < 0) {
            return 0;
        }

        int currentHouseMoney = nums[i];

        int moneySum = Math.max(rob_DP_Memo(nums, i - 2, memoMap) + currentHouseMoney, rob_DP_Memo(nums, i - 1, memoMap));

        memoMap.put(i, moneySum);

        return memoMap.get(i);
    }
}
