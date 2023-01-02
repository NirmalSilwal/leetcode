class Solution {
    public int[] runningSum(int[] nums) {
        
        int[] result = new int[nums.length];
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            result[i] = runningSum;
        }
        
        return result;
    }
}