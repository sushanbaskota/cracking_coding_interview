import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GridTraveler {

    public static void main(String[] args) {
        System.out.println(gridTraveler_recursive(1, 1)); //1
        System.out.println(gridTraveler_recursive(2, 3));  // 3
        System.out.println(gridTraveler_recursive(3, 2)); //3
        System.out.println(gridTraveler_recursive(3, 3)); // 6
        // System.out.println(gridTraveler_recursive(18, 18)); // 2333606220
        System.out.println(gridTraveler_DP(18, 18, new HashMap<>())); // 2333606220
        System.out.println(gridTraveler_DP(1, 1, new HashMap<>())); // 1
        System.out.println(gridTraveler_DP(2, 3, new HashMap<>())); // 3
        System.out.println(gridTraveler_DP(3, 2, new HashMap<>())); // 3
        System.out.println(gridTraveler_DP(3, 3, new HashMap<>())); // 6
    }

    public static long gridTraveler_recursive(int row, int col) {
        if (row == 0 || col == 0) { // invalid
            return 0;
        }

        if (row == 1 && col == 1) {
            return 1;
        }

        return gridTraveler_recursive(row - 1, col) + gridTraveler_recursive(row, col - 1); // sum of going down and right
    }

    public static Long gridTraveler_DP(int row, int col, Map<Matrix, Long> memo) {
        Matrix matrix = new Matrix(row, col);

        if (memo.containsKey(matrix)) {
            return memo.get(matrix);
        }

        if (row == 0 || col == 0) { // invalid
            return 0L;
        }

        if (row == 1 && col == 1) {
            return 1L;
        }

        memo.put(matrix, gridTraveler_DP(row - 1, col, memo) + gridTraveler_DP(row, col - 1, memo));

        return memo.get(matrix);
    }

    public static class Matrix {
        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Matrix matrix = (Matrix) object;
            return row == matrix.row && col == matrix.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
