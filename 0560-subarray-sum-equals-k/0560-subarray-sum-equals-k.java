class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixMap = new HashMap();
        int count = 0, runningSum = 0;

        prefixMap.put(0, 1); // subarray starting from 0th index with sum k has 1 count

        for (int n : nums) {
            runningSum += n;

            if (prefixMap.containsKey(runningSum - k)) {
                count += prefixMap.get(runningSum - k);
            }

            prefixMap.put(runningSum, prefixMap.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }
}