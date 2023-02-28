import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.

        Arrays.sort(queries);

        int currentSum = 0;
        int totalMinSum = 0;

        for (int i = 0; i < queries.length - 1; i++) {
            currentSum = currentSum + queries[i];
            totalMinSum = totalMinSum + currentSum;
        }

        return totalMinSum;
    }

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        //       blueShirtHeights.sort(redShirtHeights);
        Integer redShirtHeight = redShirtHeights.get(0);
        Integer blueShirtHeight = blueShirtHeights.get(0);

        //red are 2nd row
        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (redShirtHeight > blueShirtHeight) { // red 2nd row
                if (blueShirtHeights.get(i) > redShirtHeights.get(i)) { // if blue is larger return false
                    return false;
                }
            } else if (redShirtHeight < blueShirtHeight) { // red 1st row
                if (blueShirtHeights.get(i) < redShirtHeights.get(i)) { // if blue is larger return false
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        minimumWaitingTime(new int[]{3, 2, 1, 2, 6});
    }
}
