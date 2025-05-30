class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // sort by last index
        
        int arrows = 1;
        int lastIndex = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastIndex) {
                arrows++;
                lastIndex = points[i][1];
            }
        }


        return arrows;
    }
}