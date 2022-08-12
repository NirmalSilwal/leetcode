class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        
        int  top = 0, left = 0, right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        
        
        while (left <= right && top <= bottom) {
            
            // traverse left to right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;

            // traverse top to bottom
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }        
            right--;

            if (left > right || top > bottom)
                break;
            
            // traverse right to left
            for (int i = right; i >= left; i--) {
                spiral.add(matrix[bottom][i]);
            }
            bottom--;

            // traverse bottom to top
            for (int i = bottom; i >= top; i--) {
                spiral.add(matrix[i][left]);
            }
            left++;
            
        }
        
        return spiral;
    }
}