class Solution {
    // O(n) time, O(k) space
    public boolean containsNearbyDuplicateOptimal(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) return true;

            window.add(nums[i]);

            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }

    // O(n*k) time, O(1) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // sliding window range at each step, i to i+k
            for (int j = i + 1; j < n && j <= i + k; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

}