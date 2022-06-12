class Solution {
    
    // brute force way - O(N^2) time, O(N) space
    /*
    public int maximumUniqueSubarray(int[] nums) {
        // edge cases
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        
        int maxsum = 0; // since nums[i] are positive, 
        Set<Integer> set = null; // to track each unique subarray
        
        for (int i = 0; i < nums.length; i++) {
            
            set = new HashSet<>(); // reset for each subarray from ith position
            int currentsum = 0; // compute subarray sum
            
            for (int j = i; j < nums.length; j++) {
               
                if (!set.contains(nums[j])){                   
                    set.add(nums[j]);
                    currentsum += nums[j];
                    maxsum = Math.max(maxsum, currentsum);                
                } else 
                    break;
            }
        }
        return maxsum;
    }
    */
    
    // optimal approach - O(N) Time, O(N) Space
        public int maximumUniqueSubarray(int[] nums) {
            // edge cases
            if (nums == null || nums.length < 1) return 0;
            if (nums.length == 1) return nums[0];
            
            int maxsum = 0;
            Set<Integer> set = new HashSet<>();
            int currentsum = 0;
            
            // two pointers
            int start = 0, end = 0;
            
            while (end < nums.length) {
                if (!set.contains(nums[end])) {
                    set.add(nums[end]);
                    currentsum += nums[end];
                    maxsum = Math.max(maxsum, currentsum);
                    end++;
                } else {
                    currentsum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
            }
            
            return maxsum;
        }
    

}