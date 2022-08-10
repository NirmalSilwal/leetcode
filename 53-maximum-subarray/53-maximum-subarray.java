class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        for (int n : nums) {
            currSum += n;
            
            maxSum = Math.max(currSum, maxSum);
            
            if (currSum < 0)
                currSum = 0;
        }
        
        return maxSum;
    }
}