class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                     dp[i][j] = 1; // every single box is 1X1 square on itself
                } else {
                    continue;
                }
                
                // only try to grow the square if we're not at the border
                if (i > 0 && j > 0 
                    && matrix[i-1][j] == '1' // top
                    && matrix[i][j-1] == '1' // left
                    && matrix[i-1][j-1] == '1') { // top-left

                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
                maxSquare = Math.max(dp[i][j], maxSquare);
            }
        }

        return maxSquare * maxSquare;
    }
}