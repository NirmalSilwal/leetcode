class Solution {
    
    // 1st approach O(N) time, O(N) space
    public int[] runningSum(int[] nums) {
        
        if (nums.length == 1) return nums;
        
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        
        return runningSum;
    }
}