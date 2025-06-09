class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int targetSum = target - nums[i];
            if (freqMap.containsKey(targetSum)) {
                return new int[] {i, freqMap.get(targetSum)};
            } else {
                freqMap.put(nums[i], i);
            }
        }

        return new int[2];
    }
}