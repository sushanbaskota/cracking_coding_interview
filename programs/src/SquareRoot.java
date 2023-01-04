public class SquareRoot {
    /**
     * Optimal_Solution using BST
     * root(x) = y, so x = y^2, we need to find the y, such that y^2 = x
     * BST is best here for search as its O[log(n)]
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long low = 1; // int low = 1
        long high = x; // int high = 1

        while (low <= high) {
            long mid = (low + high) / 2;

            if (mid * mid == x) { // mid == x / mid
                return (int) mid;  // return mid
            } else if (mid * mid < x) { // mid > x / mid
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) high; // return high [need to return the smallest number between high and low, when it comes here, high is always smallest]
    }

    /**
     * Repeated Subtraction Method of Square Root
     * We subtract the consecutive odd numbers from the number for which we are
     * finding the square root, till we reach 0. The number of times
     * we subtract is the square root of the  given number is the square root.
     * time : O(n), space O(1)
     *
     * @param x
     * @return
     */
    public int mySqrt_repeatedSubtractionMethod(int x) {
        int count = 0;
        int oddNum = 1;

        while (x > 0) {
            x = x - oddNum;
            if (x < 0) {
                break;
            }
            oddNum = oddNum + 2;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        //    System.out.println(new SquareRoot().mySqrt(4));
        System.out.println(new SquareRoot().mySqrt(8));
    }
}
