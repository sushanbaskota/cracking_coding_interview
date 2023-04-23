import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        int result = binarySearch2(arr, target);

        System.out.println(result); // {3,6}

        //System.out.println(binarySearch1(arr, target));
    }

    public static int[] binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        List<Integer> resultList = new ArrayList<>();

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target && !resultList.contains(mid)) {
                resultList.add(mid);
            } else if (arr[mid] < target) { // change start
                start = mid + 1;
            } else { // change end
                end = mid - 1;
            }
        }

        int listSize = resultList.size();

        if (resultList.isEmpty()) { // empty not found
            return new int[]{-1, -1};
        } else if (listSize == 1) { // found only single element
            Integer firstElement = resultList.get(0);

            return new int[]{firstElement, firstElement};
        } else { // size >= 2
            resultList.sort(Comparator.comparingInt(s -> s));
            return new int[]{resultList.get(0), resultList.get(listSize - 1)};
        }
    }

    public static int binarySearch1(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) { // change start
                start = mid + 1;
            } else { // change end
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearch2(int[] array, int target) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + end / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
