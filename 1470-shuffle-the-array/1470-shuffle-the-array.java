class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] result = new int[nums.length];
        int start = 0, end = n;

        for (int i = 0; i < 2 * n; i+= 2) {
            result[i] = nums[start++];
            result[i + 1] = nums[end++];
        }

        return result;
    }
}