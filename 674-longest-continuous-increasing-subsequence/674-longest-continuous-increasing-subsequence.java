class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int lis = 0;
        int start = 0;
        
        for (int slidePos = 0; slidePos < nums.length; slidePos++) {
            // if decreasing sequence, we fix the start point of our sliding window
            if (slidePos > 0 && nums[slidePos - 1] >= nums[slidePos]) {
                start = slidePos;
            }
            
            lis = Math.max(lis, slidePos - start + 1);
        }
        
        return lis;
    }
}