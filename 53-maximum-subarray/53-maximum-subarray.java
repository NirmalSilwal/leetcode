class Solution {
    // 1st approach - using Kadane's algorithm
    public int maxSubArray1(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        
        for (int n : nums) {
            
            currSum += n;
            
            max = Math.max(max, currSum);
            
            if (currSum < 0)
                currSum = 0;
        }
        
        return max;
    }
    
    // 2nd approach
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        int max = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }

}