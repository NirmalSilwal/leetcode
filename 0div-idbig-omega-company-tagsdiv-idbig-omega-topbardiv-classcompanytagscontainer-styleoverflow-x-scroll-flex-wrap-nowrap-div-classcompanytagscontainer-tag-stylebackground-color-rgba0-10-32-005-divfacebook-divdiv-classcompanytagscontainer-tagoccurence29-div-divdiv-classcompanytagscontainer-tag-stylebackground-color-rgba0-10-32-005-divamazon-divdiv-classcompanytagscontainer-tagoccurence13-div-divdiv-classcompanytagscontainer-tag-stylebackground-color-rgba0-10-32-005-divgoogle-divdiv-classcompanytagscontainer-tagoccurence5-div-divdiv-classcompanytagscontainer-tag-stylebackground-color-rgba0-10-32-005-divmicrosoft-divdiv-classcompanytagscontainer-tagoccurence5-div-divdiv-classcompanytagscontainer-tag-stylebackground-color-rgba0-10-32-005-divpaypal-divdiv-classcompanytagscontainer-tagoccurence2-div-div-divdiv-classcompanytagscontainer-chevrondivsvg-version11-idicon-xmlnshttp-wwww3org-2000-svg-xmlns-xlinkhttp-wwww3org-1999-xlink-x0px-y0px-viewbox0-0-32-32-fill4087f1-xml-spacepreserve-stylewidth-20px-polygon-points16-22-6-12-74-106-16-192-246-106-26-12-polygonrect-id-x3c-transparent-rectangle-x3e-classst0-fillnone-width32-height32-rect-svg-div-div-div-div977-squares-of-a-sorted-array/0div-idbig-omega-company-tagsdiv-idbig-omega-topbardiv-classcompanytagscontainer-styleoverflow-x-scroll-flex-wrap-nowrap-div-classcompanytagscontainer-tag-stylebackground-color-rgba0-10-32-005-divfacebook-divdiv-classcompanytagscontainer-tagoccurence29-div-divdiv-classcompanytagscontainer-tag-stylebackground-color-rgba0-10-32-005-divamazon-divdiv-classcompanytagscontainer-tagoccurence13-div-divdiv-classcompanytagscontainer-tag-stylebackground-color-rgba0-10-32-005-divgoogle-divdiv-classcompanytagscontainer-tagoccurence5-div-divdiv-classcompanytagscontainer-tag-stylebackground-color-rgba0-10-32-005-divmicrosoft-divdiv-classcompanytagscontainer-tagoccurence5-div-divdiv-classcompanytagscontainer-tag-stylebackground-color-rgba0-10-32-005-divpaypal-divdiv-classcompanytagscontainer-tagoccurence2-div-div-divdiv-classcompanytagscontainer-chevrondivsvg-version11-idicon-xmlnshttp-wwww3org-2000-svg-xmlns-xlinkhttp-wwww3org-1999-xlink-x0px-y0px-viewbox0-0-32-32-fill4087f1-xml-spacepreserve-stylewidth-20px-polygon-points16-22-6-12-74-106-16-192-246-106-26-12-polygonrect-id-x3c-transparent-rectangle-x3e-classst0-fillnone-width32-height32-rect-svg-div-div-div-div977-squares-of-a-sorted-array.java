class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;

        for (int k = n - 1; k >= 0; k--) {
            int leftEndSquare = nums[left] * nums[left];
            int rightEndSquare = nums[right] * nums[right];

            if (leftEndSquare > rightEndSquare) {
                result[k] = leftEndSquare;
                left++;
            } else {
                result[k] = rightEndSquare;
                right--;
            }
        }

        return result;
    }
}