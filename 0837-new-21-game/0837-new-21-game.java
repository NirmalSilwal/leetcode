class Solution {
    public double new21Game(int n, int k, int maxPts) {
        
        if (k == 0 || n >= k + maxPts) return 1;
        
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double currentSum = dp[0];
        
        for (int i = 1; i <= n; i++) {
            
            dp[i] = currentSum / (double) maxPts;
            
            if (i < k)
                currentSum += dp[i];
            
            if (i - maxPts >= 0) 
                currentSum -= dp[i - maxPts];
        }
        
        double score = 0;
        for (int i = k; i <= n; i++) {
            score += dp[i];
        }
        
        return score;
    }
}