class Solution {
    // approch 1 - using max heap
    public int findKthLargest(int[] nums, int k) {
        // 1st forming max heap from all elements in array
        // then popping k elements from heap to get kth largest item
        Queue<Integer> pqueue = new PriorityQueue<>((a,b) -> b-a);
        
        for (int n : nums) {
            pqueue.add(n);
        }
        int kthLargest = Integer.MIN_VALUE;
        
        for (int i = 0; i < k; i++) {
            kthLargest = pqueue.poll();
        }
        
        return kthLargest;
    }
}