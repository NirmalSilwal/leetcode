class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stones : piles) {
            maxHeap.add(stones);
        }

        for (int i = 0; i < k ; i++) {
            int currentStone = maxHeap.poll();
            int stonesToRemove = (int) Math.floor(currentStone / 2);
            maxHeap.add(currentStone - stonesToRemove);
        }
        
        int totalStonesLeft = 0;
        while (!maxHeap.isEmpty()) {
            totalStonesLeft += maxHeap.poll();
        }
        
        return totalStonesLeft;
    }
}