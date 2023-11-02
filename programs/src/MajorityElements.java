import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1}));

    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num) + 1;

                countMap.put(num, count);

                if (count > (nums.length / 2)) {
                    return num;
                }
            } else {
                countMap.put(num, 1);
            }
        }

        return nums[0];
    }
}
