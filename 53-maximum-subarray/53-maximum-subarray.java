class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1 ) return 0;
        
        int maxsum = nums[0];
        int currsum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            
            currsum = Math.max(nums[i], currsum + nums[i]);
            
            maxsum = Math.max(maxsum, currsum);
            
            if (currsum < 0)
                currsum = 0;
        }
        
        return maxsum;
    }
}