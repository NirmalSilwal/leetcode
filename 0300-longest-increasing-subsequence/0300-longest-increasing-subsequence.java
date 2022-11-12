class Solution {
    // O(N^2) time solution
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            
            // check from 0th index till before i for all smaller elements than that the element at ith position
            for (int j = 0; j < i; j++) {
                // element at ith position is larger than jth position, which is before ith position
                if (nums[i] > nums[j]) { 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}