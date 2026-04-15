class Solution {
    public static double knightProbability(int n, int k, int row, int column) {
        // all knight moves
        int[][] directions = {
                {-2, -1}, {-2, 1}, {1, 2}, {1, -2},
                {-1, -2}, {-1, 2}, {2, 1}, {2, -1}
        };

        // dp[r][c] = probability of knight being at cell (r, c)
        double[][] current = new double[n][n];
        current[row][column] = 1.0;

        // make k moves
        for (int move = 1; move <= k; move++) {
            double[][] next = new double[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {

                    if (current[r][c] != 0) {

                        for (int[] dir : directions) {
                            int nr = r + dir[0]; // new row
                            int nc = c + dir[1]; // new column

                            // boundary check in board
                            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                                next[nr][nc] += current[r][c] / 8.0;
                            }
                        }
                    }
                }
            }
            current = next;
        }

        // sum all probabilities
        double result = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result += current[r][c];
            }
        }

        return result;
    }
}