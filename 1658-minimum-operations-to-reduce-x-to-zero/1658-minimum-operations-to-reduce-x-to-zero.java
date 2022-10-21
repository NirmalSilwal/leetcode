class Solution {
    // maximum length of subarray with sum = (total - x)
    public int minOperations(int[] nums, int x) {
        
        int target = Arrays.stream(nums).sum();
        target -= x;
        
        if (target == 0) return nums.length;
        
        Map<Integer, Integer> map = new HashMap<>(); // prefix sum, index at array
        map.put(0, -1); // prefix sum zero at index -1
        
        int result = -1, prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
           
            prefixSum += nums[i];
            
            if (map.containsKey(prefixSum - target)) {
                result = Math.max(result, i - map.get(prefixSum - target));
            }
            map.put(prefixSum, i);
        }
        
        return result == -1 ? -1 : nums.length - result;
    }
}