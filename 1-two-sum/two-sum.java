class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        for (int idx = 0 ; idx < nums.length; idx++) {
            int targetSum = target - nums[idx];
            if (map.containsKey(targetSum)) {
                return new int[] {idx, map.get(targetSum)};
            } else {
                map.put(nums[idx], idx);
            }
        }
        return new int[2];
    }
}