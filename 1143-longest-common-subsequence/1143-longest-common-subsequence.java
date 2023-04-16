class Solution {
    // top down DP
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];
        
        for (int row = 1; row <= m; row++) {
            
            for (int col = 1; col <= n; col++) {
                
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = 1 + dp[row - 1][col - 1]; // upper left diagonal
                } else {
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }

        return dp[m][n];
    }
}