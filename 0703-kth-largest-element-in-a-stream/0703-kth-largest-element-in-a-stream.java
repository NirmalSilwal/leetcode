class KthLargest {

    PriorityQueue<Integer> minHeap;
    int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        minHeap = new PriorityQueue<>();

        for (int n : nums) minHeap.add(n);   
        // maintain only K elements in heap
        while (minHeap.size() > k) minHeap.poll();
    }
    
    public int add(int val) {
        minHeap.add(val);
        
        while (minHeap.size() > kth) minHeap.poll();
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */