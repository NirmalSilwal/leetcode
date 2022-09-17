class Solution {
    // using Kadane's algorithm
    public int maxSubArray(int[] nums) {
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
}