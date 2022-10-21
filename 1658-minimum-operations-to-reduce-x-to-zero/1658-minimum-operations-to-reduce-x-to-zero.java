class Solution {
    // using prefix sum with hashmap
    // longest consecutive array with sum = total - target 
    // target = left side + right side removed elements
    // O(N) time, O(N) space
    public int minOperations1(int[] nums, int x) {
        
        int targetSum = Arrays.stream(nums).sum() - x;
        
        Map<Integer, Integer> map = new HashMap<>(); // prefix sum, index in nums
        map.put(0, -1);
        
        int operations = -1; // max length subarray
        int runningSum = 0;
        
        for (int index = 0; index < nums.length; index++) {
            
            runningSum += nums[index];
            
            map.put(runningSum, index);
           
            if (map.containsKey(runningSum - targetSum)) {
                operations = Math.max(operations, index - map.get(runningSum - targetSum));
            }
            
        }
         
        return operations == -1 ? -1 : nums.length - operations;
    }
    
    // using sliding window approach - O(N) time O(1) space
    public int minOperations(int[] nums, int x) {
        
        int target = Arrays.stream(nums).sum() - x;

        if (target < 0) return -1;
        if (target == 0) return nums.length;
        
        int operations = -1, windowSum = 0;
        int start = 0, end = 0;
        
        while (end < nums.length) {

            windowSum += nums[end];
            
            // slide window from left to right
            while (windowSum > target) {
                windowSum -= nums[start];
                start++;
            }
            
            if (windowSum == target) {
                operations = Math.max(operations, end - start + 1); 
            } 
            
            end++;
        }
        
        return operations == -1 ? -1 : nums.length - operations;
    }
    
}