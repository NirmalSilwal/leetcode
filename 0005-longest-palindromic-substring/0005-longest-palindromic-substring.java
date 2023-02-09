class Solution {
    // DP approach
    public String longestPalindrome(String s) {
      
        int n = s.length();
        if (n == 1) return s;
      
        // dp[1][2] represents substring of s in range [1,2] inclusive is palindrome or not
        // 1 indicates palindrome in dp array and 0 represents not a palindrome
        int[][] dp = new int[n][n];
        
        int start = 0, end = 0; // index of answer in s

        for (int i = 0; i < n; i++) { // start position in s
            // for upper triangular matrix
            for (int j = i; j >= 0; j--) { // end position in s
        
                if (i == j) dp[i][j] = 1;

                else if (i - j == 1) { // for substring of length 2 in upper traingular matrix
                    if (s.charAt(i) == s.charAt(j)) dp[i][j] = 1;
                } 
                else if (s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1] == 1) {
                        dp[i][j] = 1;
                }

                if (dp[i][j] == 1 && i - j > end - start) {
                    start = j;
                    end = i;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}