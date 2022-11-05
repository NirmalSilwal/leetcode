class Solution {
    // brute force - O(N) Time, O(1) Space
    public int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(n, min);
        }
        return min;
    }
    
    // optimal - binary search, O(logN) time, O(1) space
    public int findMin(int[] nums) {
        
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        
        if (nums.length == 1) return nums[0];
        
        int min = Integer.MAX_VALUE;
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            
            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        
        return min;
    }
    
}