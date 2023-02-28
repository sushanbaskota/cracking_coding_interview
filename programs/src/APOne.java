public class APOne {
    public static boolean hasOne(int n) {
        while (n != 0) {
            int rem = n % 10;

            if (rem == 1) {
                return true;
            }

            n = n / 10;
        }

        return false;
    }

    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        if (groupSum(start + 1, nums, target - nums[start])) {
            return true;
        }

        if (groupSum(start + 1, nums, target)) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 8};
        System.out.println(groupSum(0, arr, 10));
    }

}
