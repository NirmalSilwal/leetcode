class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            sum += num;

            // check if there is prefix sum that we can subtract to get k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // update the map with current prefix sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum , 0) + 1);
        }

        return count;
    }
}