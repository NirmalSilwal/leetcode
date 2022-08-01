class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i); // remaining sum and current index
            } else {
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
        }
       
        return result;
    }
}