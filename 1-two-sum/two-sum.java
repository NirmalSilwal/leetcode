class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
            int targetSum = target - nums[i];
            if (map.containsKey(targetSum)) {
                return new int[]{i, map.get(targetSum)};
            } else {
                map.put(nums[i], i);
            }
       } 
       return new int[2];
    }
}