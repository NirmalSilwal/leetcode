class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int weight : stones) {
            maxHeap.add(weight);
        }
        
        while (maxHeap.size() > 2) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
           
            if (x != y) {
                maxHeap.add(Math.abs(x - y));
            }
        }
        
        if (maxHeap.isEmpty()) return 0;
        
        else if (maxHeap.size() == 2) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x == y) return 0;
            else return Math.abs(x - y);
        } 
        else return maxHeap.poll();
    }
}