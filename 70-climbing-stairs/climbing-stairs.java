class Solution {
    public int climbStairs(int n) {
        // similar to forming fibonacci series using dp 1d array
        int one = 1, two = 1;

        for (int i = n - 1; i > 0; i--) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}