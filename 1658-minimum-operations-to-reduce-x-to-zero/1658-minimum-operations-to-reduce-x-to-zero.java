class Solution {
    // using prefix sum with hashmap
    // longest consecutive array with sum = total - target 
    // target = left side + right side removed elements
    public int minOperations(int[] nums, int x) {
        
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
}