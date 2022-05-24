class Solution {
    
    // approach 1 - recursive - TLE code so we add dp cache
    int dp[][][] = null;
    public int findMaxForm(String[] strs, int m, int n) {
        
        dp = new int[m+1][n+1][strs.length]; // add this in recursion code
        
        int[][] strFrequency = new int[strs.length][2];
        int pos = 0;
        
        for (String currStr : strs) {
            strFrequency[pos] = countOnesZeros(currStr);
            pos++;
        }
        
        return helper(strs, m, n, 0, strFrequency);
    }
    
    private int helper(String[] strs, int m, int n, int index, int[][] strFreq){
        if (index >= strs.length )
            return 0;
        
        if (dp[m][n][index] > 0)
            return dp[m][n][index];
        
        int currZeroCounts = strFreq[index][0]; // zeros count in current string
        int currOneCounts = strFreq[index][1];
        
        int countIfCurrIncluded = 0; // count if current str is included
        int countIfCurrExcluded = 0; // count if current str is excluded
        
        if (m >= currZeroCounts && n >= currOneCounts) { // include current string
         countIfCurrIncluded = 1 + helper(strs, m - currZeroCounts, n - currOneCounts, index+1, strFreq);   
        }
        
        countIfCurrExcluded = helper(strs, m, n, index + 1, strFreq);
        
        dp[m][n][index] =  Math.max(countIfCurrIncluded, countIfCurrExcluded);
        
        return dp[m][n][index];

    }
    
    private int[] countOnesZeros(String str){
        int[] counts = new int[2];
        
        for (char ch : str.toCharArray()){
            if (ch == '0')
                counts[0]++;
            else
                counts[1]++;
        }
        return counts;
    }
}