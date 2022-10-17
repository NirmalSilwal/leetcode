class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int element = 0;
        int left = 0, right = n - 1, top = 0, bottom = n - 1; // position in matrix
        
        while (left <= right && top <= bottom) {
            
            // left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++element;
            }
            top++;
            
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = ++element;
            }
            right--;
            
            if (left > right || top > bottom)
                return matrix;
            
            // right to left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = ++element;
            }
            bottom--;
            
            // bottom to top
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = ++element;
            }
            left++;
        }
        
        return matrix;
    }
}