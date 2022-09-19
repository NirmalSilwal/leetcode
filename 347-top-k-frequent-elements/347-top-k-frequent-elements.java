class Solution {
    // Approach 1 - sorting
    public int[] topKFrequent(int[] nums, int k) {
        
        if (k == nums.length) return nums;
        
        Map<Integer, Integer> map = new HashMap<>(); // number, count
        
        for (int n : nums) {
            if (!map.containsKey(n))
                map.put(n, 1);
            else 
                map.put(n, map.get(n) + 1);
        }
         
        // prioritizing less frequent element first in the heap
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        
        int[] result = new int[k];
       
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        
        return result;
    }
}