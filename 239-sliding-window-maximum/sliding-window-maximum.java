class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        if (k == 1) return nums;

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {
            // remove indices that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // remove from back all elements smaller than current element
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // add current index
            deque.offerLast(i);

            // front of deque will have max value but in full window
            if (i >= k -1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
         }

        return result;
    }
}