public class GridTravelerTabulation {

    public static void main(String[] args) {

        System.out.println(gridTraveler_tabulation(18, 18)); // 2333606220
        //System.out.println(gridTraveler_DP(1, 1)); // 1
        System.out.println(gridTraveler_tabulation(3, 3)); // 3
        //System.out.println(gridTraveler_DP(3, 2)); // 3
        //System.out.println(gridTraveler_DP(3, 3)); // 6
    }


    public static Long gridTraveler_tabulation(int row, int col) {
        long[][] matrix = new long[row + 1][col + 1];

        matrix[0][0] = 0;
        matrix[1][1] = 1;

        for (int r = 0; r <= row; r++) {
            for (int c = 0; c <= col; c++) {
                long current = matrix[r][c];
                //  System.out.println("[" + r + ", " + c + "] => " + current);

                if (r + 1 <= row) {
                    matrix[r + 1][c] += current;
                }

                if (c + 1 <= col) {
                    matrix[r][c + 1] += current;
                }
            }
        }

        return matrix[row][col];
    }
}
