class Solution {
    public int findMinArrowShots(int[][] points) {
    
        // sorting this way will fail this test case 
        // [[-2147483646,-2147483645],[2147483646,2147483647]]
        // Arrays.sort(points, (a,b) -> a[1] - b[1]); 
        
        // sorting using this way to handle larger numbers
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1])); // sort by end index
        
        int arrows = 1;
        int lastIndex = points[0][1]; // initialize with end index of 1st points
              
        for (int i = 1; i < points.length; i++) {
            
            if (points[i][0] > lastIndex) {
                arrows++;
                lastIndex = points[i][1];
            } 
        }
        
        return arrows;
    }
}
/*
[[10,16],[2,8],[1,6],[7,12]]
sort by 1st index- [[1,6], [2,8], [7,12], [10,16]]
[1,6], [2,8], [7,9]
[1,6], [2,8], [3,9]
[7,12], [10,16]
*/