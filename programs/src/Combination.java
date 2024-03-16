public class Combination {

    public static void main(String[] args) {

        var dello = """
                hello puja "k" ca , muilya 'kjkj' ; jjgsd-tertmbok dlfks= dm.a.,,;
                 ;,,;looking
                """;

        System.out.println(dello);

        // System.out.println(isSumSet(0, new int[]{10, 20, 30, 40}, 50));
        // System.out.println(isSumSet(0, new int[]{10, 20, 30, 40}, 25));
        System.out.println(isSumSet(0, new int[]{5, 6, 2}, 8));
        System.out.println("==========");
        System.out.println(groupSum6(0, new int[]{5, 6, 2}, 7));
    }

    public static boolean isSumSet(int start, int[] nums, int target) {
        // if target is 0, then that set is valid
        if (target == 0) {

            System.out.println("target");
            return true;
        }

        System.out.println("count");

        // if we traversed until then depth of input array size and still
        // target is not zero
        if (start >= nums.length) {
            return false;
        }

        //include the current element on the subset
        boolean includeCurrent = isSumSet(start + 1, nums, target - nums[start]);

        // exclude the current element on the subset
        boolean excludeCurrent = isSumSet(start + 1, nums, target);

        //return true if either include or exclude gives sum
        return includeCurrent || excludeCurrent;
    }

    public boolean findAllSumSet(int start, int[] nums, int target) {

        // if target is 0, then that set is valid
        if (target == 0) {

            System.out.println("target");
            return true;
        }

        System.out.println("count");

        // if we traversed until then depth of input array size and still
        // target is not zero
        if (start >= nums.length) {
            return false;
        }

        //include the current element on the subset
        boolean includeCurrent = isSumSet(start + 1, nums, target - nums[start]);

        // exclude the current element on the subset
        boolean excludeCurrent = isSumSet(start + 1, nums, target);

        //return true if either include or exclude gives sum
        return includeCurrent || excludeCurrent;
    }

    public static boolean groupSum6(int start, int[] nums, int target) {
        // if we traversed until then depth of input array size
        // if target is zero its valid else invalid
        if (start >= nums.length) {
            return target == 0;
        }

        //include the current element on the subset
        if (groupSum6(start + 1, nums, target - nums[start])) return true;

        // exclude the current element on the subset except 6
        if (nums[start] != 6) {
            if (groupSum6(start + 1, nums, target)) return true;
        }

        //if it reaches here return false
        return false;
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        // if we traversed until then depth of input array size
        // if target is zero its valid else invalid
        if (start >= nums.length) {
            return target == 0;
        }

        int rem = start % 2;

        //include the even current element on the subset
        if (rem == 0) {
            if (groupNoAdj(start + 1, nums, target - nums[start])) return true;
        }

        // exclude the odd current element on the subset
        if (rem == 1) {
            if (groupNoAdj(start + 1, nums, target)) return true;
        }

        //if it reaches here return false
        return false;
    }


}

