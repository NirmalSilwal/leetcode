class Solution {

    public class Pair<K, V> {
        K first;
        V second;
        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {

        List<Pair<Integer, Integer>> pairList = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++) {
            pairList.add(new Pair<>(nums1[i], nums2[i]));
        }
        // sort nums2 in descending order, maintain same index order in nums1 also
        pairList.sort((p1, p2) -> p2.second - p1.second);

        long runningSum = 0;
        long result = 0;
        // to keep track of minimum value in running sum from nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (Pair<Integer, Integer> currentPair : pairList) {
            
            int n1 = currentPair.first;
            int n2 = currentPair.second;

            runningSum += n1;
            minHeap.add(n1);

            if (minHeap.size() > k) {
                int removedSmallerValueFromNums1 = minHeap.poll();
                runningSum -= removedSmallerValueFromNums1;
            } 
            
            if (minHeap.size() == k) {
                // since nums2 have been sorted, n2 will be smallest whenever 
                // it is considered sequentially from left to right in our case
                long currentMax = runningSum * n2; 
                result = Math.max(result, currentMax);
            }
        }

        return result;
    }
}