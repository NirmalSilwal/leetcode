class Solution {
    
    // brute force approach - TLE: 18 / 20 test cases passed.
    public int minSubArrayLen1(int target, int[] nums) {
        
        int len = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
                
            if (nums[i] >= target) return 1;
            
            int temptarget = nums[i];
            int currlen = 1;

            for (int j = i + 1; j < nums.length; j++) {
                
                temptarget += nums[j];
                currlen++;                
                
                if (temptarget >= target) {
                    len = Math.min(len, currlen);
                    break;
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    
    // optimal
    public int minSubArrayLen(int target, int[] nums) {
        
        int start = 0, end = 0, runningSum = 0, windowLength = Integer.MAX_VALUE;
        
        while (end < nums.length) {
            runningSum += nums[end];
            end++;
            
            while (runningSum >= target) {
                windowLength = Math.min(windowLength, end - start);
                // moving window from start
                runningSum -= nums[start];
                start++;
            }
        }
        
        return windowLength == Integer.MAX_VALUE ? 0 : windowLength;
    }
}