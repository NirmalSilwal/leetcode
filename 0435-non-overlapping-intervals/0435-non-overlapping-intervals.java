class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        // finding total non-overlapping intervals
        int overlaps = 1;
        int endRange = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            
            if (intervals[i][0] >= endRange) {
                overlaps++;
                endRange = intervals[i][1];
            }
        }
        
        return intervals.length - overlaps;
    }
}