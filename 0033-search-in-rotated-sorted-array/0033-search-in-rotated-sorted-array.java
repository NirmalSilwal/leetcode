class Solution {
    // brute force -O(n) time - linear search
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
    
    // optimal - binary search, O(logN) time
    public int search(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) return mid;
            
            // check if left half is sorted or not
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    // target must be in this half
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}