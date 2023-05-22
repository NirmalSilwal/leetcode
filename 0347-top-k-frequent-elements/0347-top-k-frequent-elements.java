class Solution {

    public class Pair {
        int num;
        int count;
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        int[] topK = new int[k];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);

        Map<Integer, Integer> countMap = new HashMap();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entries: countMap.entrySet()) {
            Pair curr = new Pair(entries.getKey(), entries.getValue());
            maxHeap.add(curr);
        }

        int index = 0;
        for (int i = 0; i < k; i++) {
            topK[index++] = maxHeap.poll().num;
        }

        return topK;
    }
}