class Solution {
    // approach 1 - sorting
    public int[][] merge(int[][] intervals) {
        
        // sorting based on first index
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        // Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> mergedList = new LinkedList<>();  
        
        for (int[] curr : intervals) {
            
            if (mergedList.isEmpty() || mergedList.getLast()[1] < curr[0]) {
                mergedList.add(curr);
            } else {
                // if they overlaps
                mergedList.getLast()[1] = Math.max(curr[1], mergedList.getLast()[1]);
            }
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}