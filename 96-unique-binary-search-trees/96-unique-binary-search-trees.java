class Solution {
            
    // 1st approach
    /*
    int[] dp = new int[20];
    public int numTrees(int n) {
        
        if (n <= 1) return 1;
        
        if (dp[n] > 0) 
            return dp[n];
        
        for (int i = 1; i <= n; i++) {
            dp[n] += numTrees(i - 1) * numTrees(n - i);   
        }
        
        return dp[n];
    }
    */
    
    // 2nd approach
    
    /*  f(4) = f(0)*f(3) + f(1)*f(2) + f(2)*f(1) + f(3)*f(0)
        f(x) means total BST formed with x number of nodes
        for n = 4, try making root node as 1, 2, 3 and 4 each and form left and right subtree individually
        idea of Catlan number
    */
    
    public int numTrees(int n) {
        
        int[] dp = new int[n+1];
    
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            
            int left = 0;
            int right = i - 1;
            
            while (left <= i-1) {
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }
        return dp[n];
    }    
}