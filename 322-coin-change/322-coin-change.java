class Solution {
    // recursive approach - TLE
    /*
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        return coinChangeRecursion(coins, amount, 0, 0);
    }
    
    private int coinChangeRecursion(int[] coins, int amount, int index, int coinsUsed) {
        
        if (index == coins.length || amount < 0) return -1; // not possible
        
        if (amount == 0) return coinsUsed;
        
        int include = coinChangeRecursion(coins, amount - coins[index], index, coinsUsed + 1);
        
        int exclude = coinChangeRecursion(coins, amount, index + 1, coinsUsed);
        
        if (include == -1) return exclude;
        if (exclude == -1) return include;
        
        return Math.min(include, exclude);
    }
    */
    
        // DP recursive
        public int coinChange(int[] coins, int amount) {
            
            int totalCoins = coins.length;
            int[][] dp = new int[totalCoins+1][amount+1];
            
            for (int coinIdx = 0; coinIdx <= totalCoins; coinIdx++){
                
                for (int amt = 0; amt <= amount; amt++){
                    
                    if (amt == 0)
                        dp[coinIdx][amt] = 0; // first column in dp table
                    
                    else if (coinIdx == 0) // first row in dp table
                        dp[coinIdx][amt] = (int)1E+5;
                    
                    else if (coins[coinIdx-1] > amt) // current denomiation is larger than required amount
                        dp[coinIdx][amt] = dp[coinIdx - 1][amt];
                    
                    else {
                        int exclude = dp[coinIdx - 1][amt];
                        int include = 1 + dp[coinIdx][amt - coins[coinIdx - 1]];
                        
                        // find minimum from include and exclude of current coin
                        dp[coinIdx][amt] = Math.min(include, exclude);
                    }
                }
            }
            
            return dp[totalCoins][amount] > (int)1E+4 ? -1 : dp[totalCoins][amount] ;
        }    

}